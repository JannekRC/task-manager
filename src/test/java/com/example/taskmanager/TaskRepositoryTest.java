package com.example.taskmanager;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import com.example.taskmanager.domain.Person;
import com.example.taskmanager.domain.State;
import com.example.taskmanager.domain.Task;
import com.example.taskmanager.domain.TaskRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class TaskRepositoryTest {
   @Autowired
   private TaskRepository repository;
   
   @Test
    public void findByNameShouldReturnTask() {
        List<Task> tasks = repository.findByName("Have fun");
        assertThat(tasks).hasSize(1);
        assertThat(tasks.get(0).getDesc()).isEqualTo("Get some balloons or something");
    }
   
   @Test
   public void createNewTask() {
     Task task = new Task("Take pictures", "1996-12-04", "Use camera", new State("Done"), new Person("Harry"));
     repository.save(task);
     assertThat(task.getId()).isNotNull();
   }
}
