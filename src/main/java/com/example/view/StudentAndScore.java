package com.example.view;

public class StudentAndScore {
	private Long id;
	private String name;
	private Integer age;
	private Integer grade;
	private String subject;
	private Integer score;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public StudentAndScore(Long id, String name, Integer age, Integer grade, String subject, Integer score) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.subject = subject;
		this.score = score;
	}

	public StudentAndScore() {

	}

}
