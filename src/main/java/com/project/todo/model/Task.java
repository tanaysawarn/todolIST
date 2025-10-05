package com.project.todo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @EmbeddedId
    private CompositePk taskId;

    private String title;
    private boolean completed = false;

    @PrePersist
    public void prePersist() {
        // Automatically set the date if not provided
        if (taskId == null) {
            taskId = new CompositePk();
        }
        if (taskId.getDate() == null) {
            taskId.setDate(LocalDate.now());
        }
    }
}