package com.example.taskmanager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.taskmanager.domain.TaskRepository;

@Controller
public class TaskController {
	@Autowired
	private TaskRepository repository;

	@RequestMapping(value = { "/tasklist" })
	public String taskList(Model model) {
		model.addAttribute("tasks", repository.findAll());
		return "tasklist";
	}
}
