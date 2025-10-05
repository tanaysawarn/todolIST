package com.project.todo.controller;


import com.project.todo.model.CompositePk;
import com.project.todo.model.Task;
import com.project.todo.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return service.getAllTasks();
    }

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return service.addTask(task);
    }

    @PutMapping
    public Task updateTask(@RequestBody Task task) {
        CompositePk key = task.getTaskId();
        return service.updateTask(key, task);
    }

    @DeleteMapping
    public void deleteTask(@RequestBody CompositePk key) {
        service.deleteTask(key);
    }
}