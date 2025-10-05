package com.project.todo.repository;

import com.project.todo.model.Task;
import com.project.todo.model.CompositePk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, CompositePk> {
}
