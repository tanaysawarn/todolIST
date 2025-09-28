package com.project.todo;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class compositePk implements Serializable {
    private Long id;
    private LocalDate date;
}