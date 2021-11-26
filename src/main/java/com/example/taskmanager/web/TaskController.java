package com.example.taskmanager.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.taskmanager.domain.Person;
import com.example.taskmanager.domain.PersonRepository;
import com.example.taskmanager.domain.State;
import com.example.taskmanager.domain.StateRepository;
import com.example.taskmanager.domain.Task;
import com.example.taskmanager.domain.TaskRepository;
import com.example.taskmanager.domain.UserRepository;

@Controller
public class TaskController {
	@Autowired
	private TaskRepository repository;
	@Autowired
	private PersonRepository prepository;
	@Autowired
	private StateRepository srepository;
	@Autowired
	private UserRepository urepository;

	//Basic task manager features
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
	public String save(
		@RequestParam(value = "name", required = false) String name,
		@RequestParam(value = "date", required = false) String date,
		@RequestParam(value = "desc", required = false) String desc,
		@RequestParam(value = "state", required = false) State state,
		@RequestParam(value = "person", required = false) Person person
		){
		Task task = new Task(name, date, desc, state, person);
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
	
	// RESTful service to get all tasks
	@GetMapping("/tasks")
    public @ResponseBody List<Task> taskListRest() {	
        return (List<Task>) repository.findAll();
    }
	
	// RESTful service to get persons by name
		@GetMapping("/person/{name}")
		public @ResponseBody List<Person> findPersonRest(@PathVariable("name") String name) {	
	    	return prepository.findByName(name);
	}
	
	//Spring security
	@RequestMapping(value = { "/", "/login" })
	public String login(Model model) {
		model.addAttribute("users", urepository.findAll());
		return "login";
	}
}
