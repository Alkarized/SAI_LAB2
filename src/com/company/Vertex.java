package com.company;

import java.util.Objects;

public class Vertex {
    private final Integer distanceToTheFinalDestination;
    private final String name;

    public Vertex(Integer distanceToTheFinalDestination, String name) {
        this.distanceToTheFinalDestination = distanceToTheFinalDestination;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getDistanceToTheFinalDestination() {
        return distanceToTheFinalDestination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(distanceToTheFinalDestination, vertex.distanceToTheFinalDestination) && Objects.equals(name, vertex.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distanceToTheFinalDestination, name);
    }
}
