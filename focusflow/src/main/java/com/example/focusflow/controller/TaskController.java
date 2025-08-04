package com.example.focusflow.controller;

import com.example.focusflow.model.Task;
import com.example.focusflow.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/user/{userId}")
    public List<Task> getTasks(@PathVariable Long userId) {
        return taskService.getByUser(userId);
    }

    @PostMapping
    public Task save(@RequestBody Task task) {
        return taskService.save(task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.delete(id);
    }
}
