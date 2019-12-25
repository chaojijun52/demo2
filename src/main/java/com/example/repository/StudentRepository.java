package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	@Query(value = "select id from student", nativeQuery = true)
	List<Long> findAllIds();
}
