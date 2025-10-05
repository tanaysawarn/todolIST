package com.project.todo.model;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompositePk implements Serializable {
    private Long id;
    private LocalDate date;

    // Required for comparing composite keys properly
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompositePk that)) return false;
        return Objects.equals(id, that.id) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date);
    }
}
