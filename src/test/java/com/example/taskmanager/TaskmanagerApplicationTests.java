package com.example.taskmanager;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.taskmanager.web.TaskController;

@SpringBootTest
class TaskmanagerApplicationTests {
	
	@Autowired
	private TaskController controller;

	@Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
