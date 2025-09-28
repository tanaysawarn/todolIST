package com.project.todo.repository;

import com.project.todo.model.Task;
import com.project.todo.model.compositePk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, compositePk> {
}
