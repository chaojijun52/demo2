package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dao.CommonDAO;
import com.example.dao.impl.CommonDAOImpl;
import com.example.view.StudentAndScore;

@Controller
@RequestMapping(path = "/studentandscore")
public class StudentAndScoreController {
	private static final Logger LOG = LogManager.getLogger(StudentAndScoreController.class);
	@PersistenceContext

	private EntityManager entityManager;

	@GetMapping(path = "/all")
	public @ResponseBody List<StudentAndScore> getStudentAndScore() {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Now getting in /studentandscore/all");
		}
		CommonDAO<StudentAndScore> dao = new CommonDAOImpl<StudentAndScore>();
		String sql = "select s.id as id, s.name as name, s.age as age, s.grade as grade, sc.subject as subject, sc.score as score from student s, score sc where s.id=sc.sid";
		Map<String, Type> scalars = new HashMap<String, Type>();
		scalars.put("id", StandardBasicTypes.LONG);
		scalars.put("name", StandardBasicTypes.NSTRING);
		scalars.put("age", StandardBasicTypes.INTEGER);
		scalars.put("grade", StandardBasicTypes.INTEGER);
		scalars.put("subject", StandardBasicTypes.NSTRING);
		scalars.put("score", StandardBasicTypes.INTEGER);
		return dao.findAllNativeQuery(entityManager, StudentAndScore.class, sql, scalars);
	}

//	@GetMapping(path = "/get/{id}")
//	public @ResponseBody Optional<StudentAndScore> getStudentAndScoreById(@PathVariable("id") Integer id) {
//		return this.studentAndScoreRepository.findById(id);
//	}
}
