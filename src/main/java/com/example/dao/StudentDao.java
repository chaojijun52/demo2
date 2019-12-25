package com.example.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.entity.Student;

@Component
public interface StudentDao {
	public List<Long> getAllIds();
	public List<Student> getAllStudentsByIds(List<Long> ids);
	public Student addNewStudent(Student student);
	public Student getStudentById(Long id);
	public Student changeStudentById(Long id, Student student);
	public String deleteStudentById(Long id);
}
