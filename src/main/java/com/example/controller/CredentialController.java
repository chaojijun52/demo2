package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.Credential;
import com.example.repository.CredentialRepository;

@Controller
@RequestMapping(path="/oauth")
public class CredentialController {
	@Autowired
	private CredentialRepository credentialRepository;
	
@PostMapping(path="/add")
public @ResponseBody String addCredential(@RequestBody Credential credential) {
	this.credentialRepository.save(credential);
	return "saved";
}

@PostMapping(path="/login")
public @ResponseBody String login(@RequestBody Credential credential) {
	Credential user=this.credentialRepository.findByUsernameAndPassword(credential.getUsername(), credential.getPassword());
	if(user!=null)
	return "login success";
	else return "login failed";
}

@GetMapping(path="/all")
public @ResponseBody Iterable<Credential> getAllCredentials(){
	return this.credentialRepository.findAll();
}
}
