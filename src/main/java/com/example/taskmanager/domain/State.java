package com.example.taskmanager.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class State {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long stateid;
	private String desc;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "state")
	private List<Task> tasks;
	
	public State() {}
	
	public State(String desc) {
		super();
		this.desc = desc;
		
	}

	public Long getStateid() {
		return stateid;
	}

	public void setStateid(Long stateid) {
		this.stateid = stateid;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
}
