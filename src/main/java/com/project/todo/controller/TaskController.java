package com.project.todo.controller;

import com.project.todo.model.Task;
import com.project.todo.model.compositePk;
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

    // GET all tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return service.getAllTasks();
    }

    // POST new task
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return service.addTask(task);
    }

    // PUT update task
    @PutMapping("/{pk}")
    public Task updateTask(@PathVariable compositePk pk, @RequestBody Task updatedTask) {
        return service.updateTask(pk, updatedTask);
    }

    // DELETE task
    @DeleteMapping("/{pk}")
    public void deleteTask(@PathVariable compositePk pk) {
        service.deleteTask(pk);
    }
}
