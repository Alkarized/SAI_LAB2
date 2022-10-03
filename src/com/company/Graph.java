package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private Boolean[] visited;
    private final ArrayList<LinkedList<ValueIDX>> edges;
    private final ArrayList<VertexIDX> vertices;
    private final Integer dimension;
    private Integer count;

    public Graph(Integer dimension) {
        this.dimension = dimension;
        this.edges = new ArrayList<LinkedList<ValueIDX>>();
        this.visited = new Boolean[dimension];
        this.vertices = new ArrayList<VertexIDX>();
        this.count = 0;

        for (int i = 0; i < dimension; i++) {
            edges.add(new LinkedList<ValueIDX>());
        }
    }

    public Integer getDimension() {
        return this.dimension;
    }

    private Integer getNewCount() {
        return count++;
    }

    public void addVertices(Vertex... vx) {
        for (Vertex vertex : vx) {
            vertices.add(new VertexIDX(vertex, getNewCount()));
        }
    }

    private Integer findIDX(Vertex v) {
        for (VertexIDX vIDX : vertices) {
            if (vIDX.getVertex().equals(v)) {
                return vIDX.getIdx();
            }
        }

        System.out.println("Got nothing to find - IDX");
        return null;

    }

    private Vertex findVertex(Integer idx) {
        for (VertexIDX vIDX : vertices) {
            if (vIDX.getIdx().equals(idx)) {
                return vIDX.getVertex();
            }
        }

        System.out.println("Got nothing to find - Vertex");
        return null;

    }

    public void addEdge(Vertex v1, Vertex v2, Integer distance) {
        Integer idx1 = findIDX(v1);
        Integer idx2 = findIDX(v2);
        edges.get(idx1).add(new ValueIDX(distance, idx2));
        edges.get(idx2).add(new ValueIDX(distance, idx1));
    }

    public Integer[][] fillTheMatrix() {
        Integer[][] matrix = new Integer[getDimension()][getDimension()];
        for (int i = 0; i < edges.size(); i++) {
            for (int j = 0; j < edges.get(i).size(); j++) {
                matrix[i][edges.get(i).get(j).getIdx()] = edges.get(i).get(j).getValue();

            }
        }
        for (Integer[] integers : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(integers[j] + " ");
            }
            System.out.println();
        }

        return matrix;
    }

    private void clearCache() {
        Arrays.fill(visited, false);
    }

    public void startDFS(Vertex start, Vertex end) {
        clearCache();
        Integer idxStart = findIDX(start);
        Integer idxEnd = findIDX(end);
        LinkedList<Integer> data = new LinkedList<>();


        DFS(idxStart, idxEnd, data);
        data.addFirst(idxStart);
        for (int i = 0; i < data.size() - 1; i++) {
            System.out.print(findVertex(data.get(i)).getName() + " -> ");
        }
        System.out.print(findVertex(data.get(data.size() - 1)).getName());
    }

    private boolean DFS(Integer idxNow, Integer idxEnd, LinkedList<Integer> data) {
        if (idxNow.equals(idxEnd)) {
            return true;
        }
        visited[idxNow] = true;

        for (ValueIDX vIDX : edges.get(idxNow)) {
            if (!visited[vIDX.getIdx()]) {
                if (DFS(vIDX.getIdx(), idxEnd, data)) {
                    data.addFirst(vIDX.getIdx());
                    return true;
                }
            }
        }

        return false;
    }

    public void startBFS(Vertex start, Vertex end) {
        Integer idxStart = findIDX(start);
        Integer idxEnd = findIDX(end);
        clearCache();
        LinkedList<Integer> data = new LinkedList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.push(idxStart);
        visited[idxStart] = true;

        while (!queue.isEmpty()) {
            Integer cur = queue.peek();

            if (cur.equals(idxEnd)) {
                break;
            }
            queue.pop();
            data.addLast(cur);
            for (ValueIDX vIDX : edges.get(cur)) {
                if (!visited[vIDX.getIdx()]) {
                    visited[vIDX.getIdx()] = true;
                    queue.push(vIDX.getIdx());
                }
            }
        }

        for (int i = 0; i < data.size() - 1; i++) {
            System.out.print(findVertex(data.get(i)).getName() + " -> ");
        }
        System.out.print(findVertex(data.get(data.size() - 1)).getName());

    }

    public boolean startLimitDFS(Vertex start, Vertex end, Integer limit) {
        clearCache();
        Integer idxStart = findIDX(start);
        Integer idxEnd = findIDX(end);
        LinkedList<Integer> data = new LinkedList<>();
        Integer height = 0;
        if (!limitDFS(idxStart, idxEnd, height, limit, data)) {
            System.out.println("Превышен лимит!");
            return false;
        }

        data.addFirst(idxStart);

        for (int i = 0; i < data.size() - 1; i++) {
            System.out.print(findVertex(data.get(i)).getName() + " -> ");
        }
        System.out.print(findVertex(data.get(data.size() - 1)).getName());

        return true;
    }


    private boolean limitDFS(Integer idxNow, Integer idxEnd, Integer height, Integer limit, LinkedList<Integer> data) {
        if (limit < height) {
            return false;
        } else {
            if (idxNow.equals(idxEnd)) {
                return true;
            }
            visited[idxNow] = true;

            for (ValueIDX vIDX : edges.get(idxNow)) {
                if (!visited[vIDX.getIdx()]) {
                    if (limitDFS(vIDX.getIdx(), idxEnd, height + 1, limit, data)) {
                        data.addFirst(vIDX.getIdx());
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public void startLimitRiseDFS(Vertex start, Vertex end, Integer limitStart) {
        while (!startLimitDFS(start, end, limitStart)) {
            limitStart++;
            System.out.println("Новый лимит - " + limitStart);
        }
    }


    public void startDualBFS(Vertex start, Vertex end) {
        clearCache();
        Integer idxStart = findIDX(start);
        Integer idxEnd = findIDX(end);
        LinkedList<Integer> data = new LinkedList<>();

        dualBFS(idxStart, idxEnd);
        //data.addFirst(idxStart);
//        for (int i = 0; i < data.size() - 1; i++) {
//            System.out.print(findVertex(data.get(i)).getName() + " -> ");
//        }
        //System.out.print(findVertex(data.get(data.size() - 1)).getName());
    }

    private boolean dualBFS(Integer idxNow, Integer idxEnd) {
        LinkedList<Integer> data1 = new LinkedList<>();
        LinkedList<Integer> data2 = new LinkedList<>();

        ArrayDeque<Integer> queueStart = new ArrayDeque<>();
        queueStart.push(idxNow);
        ArrayDeque<Integer> queueEnd = new ArrayDeque<>();
        queueEnd.push(idxEnd);
        Integer[] colors = new Integer[getDimension()];
        for (int i = 0; i < colors.length; i++) {
            colors[i] = 0;
        }

        END:
        {
            while (!queueStart.isEmpty() || !queueEnd.isEmpty()) {
                Integer cur1 = queueStart.peek();

                if (cur1.equals(idxEnd)) {
                    break;
                }

                queueStart.pop();
                data1.addLast(cur1);
                for (ValueIDX vIDX : edges.get(cur1)) {
                    if (colors[vIDX.getIdx()] == 0) {
                        colors[vIDX.getIdx()] = 1;
                        queueStart.push(vIDX.getIdx());
                    } else if (colors[vIDX.getIdx()] == 2) {
                        data1.addLast(vIDX.getIdx());
                        break END;
                    }
                }

                Integer cur2 = queueEnd.peek();

                if (cur2.equals(idxNow)) {
                    break;
                }

                queueEnd.pop();
                data2.addFirst(cur2);
                for (ValueIDX vIDX : edges.get(cur2)) {
                    if (colors[vIDX.getIdx()] == 0) {
                        colors[vIDX.getIdx()] = 2;
                        queueEnd.push(vIDX.getIdx());
                    } else if (colors[vIDX.getIdx()] == 1) {
                        data2.addLast(vIDX.getIdx());
                        break END;
                    }
                }
            }
        }

        for (int i = 0; i < data1.size() - 1; i++) {
            System.out.print(findVertex(data1.get(i)).getName() + " -> ");
        }
        System.out.print(findVertex(data1.get(data1.size() - 1)).getName());
        System.out.println();
        for (int i = 0; i < data2.size() - 1; i++) {
            System.out.print(findVertex(data2.get(i)).getName() + " -> ");
        }
        System.out.print(findVertex(data2.get(data2.size() - 1)).getName());

        return true;
    }

    public boolean greedSearch(){
        
    }

}
