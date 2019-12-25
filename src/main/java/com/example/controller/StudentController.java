package com.example.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dao.impl.StudentDaoImpl;
import com.example.entity.Student;

@Controller
@RequestMapping(path = "/student")
public class StudentController {
	private static final Logger LOG = LogManager.getLogger(StudentController.class);

	@Autowired
	private StudentDaoImpl studentDaoImpl;//=new StudentDaoImpl();

//	@CachePut(value = "student", key = "#student.id")
	@PostMapping(path = "/add")
	public @ResponseBody Student addNewStudent(@RequestBody Student student) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Now getting in /student/add");
		}
		return this.studentDaoImpl.addNewStudent(student);
	}

//	@CacheEvict(value="student", key="#id")
	@DeleteMapping(path = "/delede/{id}")
	public @ResponseBody String deleteStudentById(@PathVariable("id") Long id) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Now getting in /student/delede/" + id);
		}
		this.studentDaoImpl.deleteStudentById(id);
		return "deleted";
	}
//
//	@CachePut(value = "student", key = "#student.id")
	@PutMapping(path = "/change/{id}")
	public @ResponseBody Student changeStudentById(@PathVariable("id") Long id, @RequestBody Student student) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Now getting in /student/change/" + id);
		}
		return this.studentDaoImpl.changeStudentById(id, student);
	}

//	@Cacheable(value = "student", key="#id")
	@GetMapping(path = "/get/{id}")
	public @ResponseBody Student getStudentById(@PathVariable("id") Long id) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Now getting in /student/get/" + id);
		}
		return this.studentDaoImpl.getStudentById(id);
	}
	
//	@Cacheable(value = "students")
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Student> getAllStudents() {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Now getting in /student/all");
		}
		List<Long> ids=this.studentDaoImpl.getAllIds();
		return this.studentDaoImpl.getAllStudentsByIds(ids);
	}
}
