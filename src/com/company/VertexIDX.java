package com.company;

public class VertexIDX {
    private final Vertex vertex;
    private final Integer idx;

    public VertexIDX(Vertex vertex, Integer idx) {
        this.vertex = vertex;
        this.idx = idx;
    }

    public Integer getIdx() {
        return idx;
    }

    public Vertex getVertex() {
        return vertex;
    }
}
