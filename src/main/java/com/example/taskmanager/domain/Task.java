package com.example.taskmanager.domain;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Task {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private LocalDate date;
	private String desc;
	
	@ManyToOne
    @JoinColumn(name = "stateid")
    private State state;
	
	@ManyToOne
    @JoinColumn(name = "personid")
    private Person person;
	
	public Task() {};
	
	public Task(String name, String date, String desc, State state, Person person) {
		super();
		this.name = name;
		this.date = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
		this.desc = desc;
		this.state = state;
		this.person = person;
	}
	
	public Task(String name, LocalDate date, String desc, State state, Person person) {
		super();
		this.name = name;
		this.date = date;
		this.desc = desc;
		this.state = state;
		this.person = person;
	}
	
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
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}


