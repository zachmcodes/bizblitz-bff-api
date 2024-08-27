package com.BizBlitz.bff_api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class BusinessHours {
    private List<Open> open;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessHours that = (BusinessHours) o;
        return Objects.equals(open, that.open);
    }

    @Override
    public int hashCode() {
        return Objects.hash(open);
    }
}
