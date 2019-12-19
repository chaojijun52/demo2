package com.example.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.Score;
import com.example.entity.Student;
import com.example.repository.StudentRepository;

@Controller
@RequestMapping(path = "/student")
public class StudentController {
	private static final Logger LOG = LogManager.getLogger(StudentController.class);

	@Autowired
	private StudentRepository studuentRepository;

	@PostMapping(path = "/add")
	public @ResponseBody String addNewStudent(@RequestBody Student student) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Now getting in /student/add");
		}
		for (Score score : student.getScores()) {
			score.setStudent(student);
		}
//		this.scoreRepository.saveAll(student.getScores());
		this.studuentRepository.save(student);
		return "saved";
	}

	@DeleteMapping(path = "/delede/{id}")
	public @ResponseBody String deleteStudentById(@PathVariable("id") Long id) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Now getting in /student/delede/" + id);
		}
		this.studuentRepository.deleteById(id);
		return "deleted";
	}

	@CachePut(value = "students", key = "#student.id")
	@PutMapping(path = "/change/{id}")
	public @ResponseBody String changeStudentById(@PathVariable("id") Long id, @RequestBody Student student) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Now getting in /student/change/" + id);
		}
		student.setId(id);
		for (Score score : student.getScores()) {
			score.setStudent(student);
		}
		this.studuentRepository.save(student);
		return "changed";
	}

	@GetMapping(path = "/get/{id}")
	public @ResponseBody Student getStudentById(@PathVariable("id") Long id) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Now getting in /student/get/" + id);
		}
		return this.studuentRepository.findById(id).get();
	}
	@Cacheable(value = "students")
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Student> getAllStudents() {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Now getting in /student/all");
		}
		return this.studuentRepository.findAll();
	}
}
