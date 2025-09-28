package com.project.todo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @EmbeddedId
    private compositePk compositePk;   // composite primary key

    private String title;

    private boolean completed = false;
}
