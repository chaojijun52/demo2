package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Score;

public interface ScoreRepository extends CrudRepository<Score, Long> {

}
