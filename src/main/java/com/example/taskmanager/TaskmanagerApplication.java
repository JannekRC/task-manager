package com.example.taskmanager;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.taskmanager.domain.Person;
import com.example.taskmanager.domain.PersonRepository;
import com.example.taskmanager.domain.Task;
import com.example.taskmanager.domain.TaskRepository;

@SpringBootApplication
public class TaskmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskmanagerApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(TaskRepository repository, PersonRepository prepository) {
		return (args) -> {
			
			prepository.save(new Person("Programming"));
			prepository.save(new Person("Business"));
			prepository.save(new Person("UX"));
			
			
			Task t1 = new Task("Have fun", LocalDate.now(), "Get some balloons or something", "To do", prepository.findByName("Programming").get(0));
			Task t2 = new Task("Laugh", LocalDate.now(), "Inhale etc.", "In progress", prepository.findByName("Business").get(0));
			Task t3 = new Task("Wash hair", LocalDate.now(), "With shampoo!", "Done", prepository.findByName("Programming").get(0));
			
			repository.save(t1);
			repository.save(t2);
			repository.save(t3);
		};
	}

}
