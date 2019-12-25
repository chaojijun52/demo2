package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Credential;

public interface CredentialRepository extends CrudRepository<Credential, Integer> {
	Credential findByUsernameAndPassword(String username, String password);
}
