package com.example.taskmanager;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.taskmanager.domain.Person;
import com.example.taskmanager.domain.PersonRepository;
import com.example.taskmanager.domain.State;
import com.example.taskmanager.domain.StateRepository;
import com.example.taskmanager.domain.Task;
import com.example.taskmanager.domain.TaskRepository;

@SpringBootApplication
public class TaskmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskmanagerApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(TaskRepository repository, StateRepository srepository, PersonRepository prepository) {
		return (args) -> {
			
			prepository.save(new Person("Harry"));
			prepository.save(new Person("Kaley"));
			prepository.save(new Person("Gwen"));
			
			srepository.save(new State("To do"));
			srepository.save(new State("In progress"));
			srepository.save(new State("Done"));
			
			
			Task t1 = new Task("Have fun", LocalDate.now().toString(), "Get some balloons or something", srepository.findByDesc("To do").get(0), prepository.findByName("Harry").get(0));
			Task t2 = new Task("Laugh", LocalDate.now().toString(), "Inhale etc.", srepository.findByDesc("In progress").get(0), prepository.findByName("Kaley").get(0));
			Task t3 = new Task("Wash hair", LocalDate.now().toString(), "With shampoo!", srepository.findByDesc("Done").get(0), prepository.findByName("Gwen").get(0));
			
			repository.save(t1);
			repository.save(t2);
			repository.save(t3);
		};
	}

}
