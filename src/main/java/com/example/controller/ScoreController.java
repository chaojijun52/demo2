package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.Score;
import com.example.repository.ScoreRepository;

@Controller
@RequestMapping(path="/score")
public class ScoreController {
@Autowired
private ScoreRepository scoreRepository;

@PostMapping(path="/add")
public @ResponseBody String addNewScore(@RequestBody Score score) {
	this.scoreRepository.save(score);
	return "saved";
}

@PutMapping(path="/change/{id}")
public @ResponseBody String changeById(@PathVariable("id") Long id, @RequestBody Score score) {
	if(!this.scoreRepository.existsById(id)) return "not exists";
//	score.setSid(id);
//	this.scoreRepository.save(score);
//	this.scoreRepository.insertWithQuery(score.getSid(), score.getScore(), score.getSubject());
	return "changed";
}

@DeleteMapping(path="/delete/{id}")
public @ResponseBody String deleteById(@PathVariable("id") Long id) {
	this.scoreRepository.deleteById(id);
	return "deleted";
}
}
