package com.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.dao.StudentDao;
import com.example.entity.Score;
import com.example.entity.Student;
import com.example.repository.StudentRepository;

@Service
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private StudentRepository studuentRepository;
	
	@Override
	public List<Long> getAllIds(){
		return studuentRepository.findAllIds();
	}
	
	@Cacheable(value = "students", key="#ids")
	@Override
	public List<Student> getAllStudentsByIds(List<Long> ids){
		return (List<Student>) studuentRepository.findAllById(ids);
	}
	
	@CachePut(value = "student", key = "#student.id")
	@Override
	public Student addNewStudent(Student student) {
		for (Score score : student.getScores()) {
			score.setStudent(student);
		}
		return studuentRepository.save(student);
	}
	
	@Cacheable(value = "student", key="#id")
	@Override
	public Student getStudentById(Long id) {
		return studuentRepository.findById(id).get();
	}
	
	@CachePut(value = "student", key = "#id")
	@Override
	public Student changeStudentById(Long id, Student student) {
		student.setId(id);
		for (Score score : student.getScores()) {
			score.setStudent(student);
		}
		return studuentRepository.save(student);
	}

	@CacheEvict(value="student", key="#id")
	@Override
	public String deleteStudentById(Long id) {
		// TODO Auto-generated method stub
		studuentRepository.deleteById(id);
		return "deleted";
	}

}
