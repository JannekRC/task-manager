package com.example.taskmanager.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StateRepository extends CrudRepository<State, Long> {

	List<State> findByDesc(String desc);

}