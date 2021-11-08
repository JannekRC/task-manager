package com.example.taskmanager;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.taskmanager.domain.Task;
import com.example.taskmanager.domain.TaskRepository;

@SpringBootApplication
public class TaskmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskmanagerApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(TaskRepository repository) {
		return (args) -> {
			Task t1 = new Task("Have fun", LocalDate.now(), "Get some balloons or something", "To do", "Tennis");
			Task t2 = new Task("Laugh", LocalDate.now(), "Inhale etc.", "In progress", "Brian");
			Task t3 = new Task("Wash hair", LocalDate.now(), "With shampoo!", "Done", "Kaley");
			
			repository.save(t1);
			repository.save(t2);
			repository.save(t3);
		};
	}

}
