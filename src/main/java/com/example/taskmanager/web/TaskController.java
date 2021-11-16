package com.example.taskmanager.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.taskmanager.domain.Person;
import com.example.taskmanager.domain.PersonRepository;
import com.example.taskmanager.domain.StateRepository;
import com.example.taskmanager.domain.Task;
import com.example.taskmanager.domain.TaskRepository;

@Controller
public class TaskController {
	@Autowired
	private TaskRepository repository;
	@Autowired
	private PersonRepository prepository;
	@Autowired
	private StateRepository srepository;

	@RequestMapping(value = { "/tasklist" })
	public String taskList(Model model) {
		model.addAttribute("tasks", repository.findAll());
		return "tasklist";
	}
	
	@RequestMapping(value = "/add")
	public String addTask(Model model){
		model.addAttribute("task", new Task());
		model.addAttribute("states", srepository.findAll());
		model.addAttribute("persons", prepository.findAll());
		return "addtask";
	}
	
	@GetMapping("/edit/{id}")
	public String editTask(@PathVariable("id") Long taskId, Model model) {
		Optional<Task> task = repository.findById(taskId);
		model.addAttribute("task", task);
		model.addAttribute("states", srepository.findAll());
		model.addAttribute("persons", prepository.findAll());
		return "edittask";
	}
	
	@PostMapping("/save")
	public String save(Task task){
		repository.save(task);
		return "redirect:tasklist";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteTask(@PathVariable("id") Long taskId, Model model) {
	repository.deleteById(taskId);
	return "redirect:../tasklist";
	}
	
	//Adding and saving new person to drop down list
	@RequestMapping(value = "/addper")
	public String addPerson(Model model){
		model.addAttribute("person", new Person());
		return "addperson";
	}
	
	@PostMapping("/saveper")
	public String save(Person person){
		prepository.save(person);
		return "redirect:tasklist";
	}
}
