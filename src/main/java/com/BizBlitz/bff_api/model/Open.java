package com.BizBlitz.bff_api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Open {
    private int day;
    private String start;
    private String end;

    // Getters and Setters

    public int getId() {
        return day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Open open = (Open) o;
        return day == open.day && Objects.equals(start, open.start) && Objects.equals(end, open.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, start, end);
    }
}
