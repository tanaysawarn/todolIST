package com.project.todo.service;


import com.project.todo.model.Task;
import com.project.todo.model.compositePk;
import com.project.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    //select * from tasks
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    //Insert into tasks
    public Task addTask(Task task){
        return taskRepository.save(task);
    }

    //Update existing task
    public Task updateTask(compositePk pk, Task updatedTask){
        return taskRepository.findById(pk).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setCompleted(updatedTask.isCompleted());
            return taskRepository.save(task);
        }).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    //delete from task
    public void deleteTask(compositePk pk){
        taskRepository.deleteById(pk);
    }
}
