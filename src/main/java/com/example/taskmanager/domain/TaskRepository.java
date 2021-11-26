package com.example.taskmanager.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {

	List<Task> findById(long taskId);
	
	List<Task> findByPerson(String name);
	
	List<Task> findByName(String name);

}