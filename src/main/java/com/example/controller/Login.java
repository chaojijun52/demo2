package com.example.controller;

import java.security.Principal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.Credential;

@Controller
public class Login {
	private static final Logger LOG = LogManager.getLogger();

	@RequestMapping(path = "/user")
	public Principal getAccess(Principal principal) {
		if(LOG.isDebugEnabled()) {
			LOG.debug("Login->/login->getAccess(@RequestBody Credential credential)");
		}
		return principal;
	}
	
	@RequestMapping(path = "/login")
	public String login(@RequestParam(value="code") String code) {
		if(LOG.isDebugEnabled()) {
			LOG.debug("Login->/login->getAccess(@RequestBody Credential credential)");
		}
		return code;
	}
}
