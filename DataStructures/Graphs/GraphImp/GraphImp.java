package GraphImp;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphImp {
    Map<Integer, List<Integer>> graph;
    int e;

    public GraphImp() {
        graph = new HashMap<Integer, List<Integer>>();
        e = 0;
    }

    public void addEdge(int v1, int v2, boolean directed) {
        if (!graph.containsKey(v1)) {
            graph.put(v1, new LinkedList<Integer>());
        }
        if (!graph.get(v1).contains(v2)) {
            graph.get(v1).add(v2);
            e++;
        }

        if (!directed) {
            if (!graph.containsKey(v2)) {
                graph.put(v2, new LinkedList<Integer>());
            }
            if (!graph.get(v2).contains(v1)) {
                graph.get(v2).add(v1);
                e++;
            }
        }
    }

    public void addVertex(int vertex) {
        if (!graph.containsKey(vertex))
            graph.put(vertex, new LinkedList<Integer>());
    }

    public boolean hasEdge(int v1, int v2) {
        return graph.containsKey(v1) ? graph.get(v1).contains(v2) : false;
    }

    public boolean hasVertex(int vertex) {
        return graph.containsKey(vertex);
    }

    public int getVertexCount() {
        return graph.size();
    }

    public int getEdgesCount() {
        return e;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Graph Empty.");
            return;
        }
        for (int v : graph.keySet()) {
            System.out.print(v + " : ");
            for (int e : graph.get(v)) {
                System.out.print(e + " -> ");
            }
            System.out.println("NULL");
        }
    }

    public void BFS() {
        if (isEmpty()) {
            System.out.println("Graph Empty.");
            return;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        List<Integer> visited = new LinkedList<Integer>();

        int elem = (int) graph.keySet().toArray()[0];
        System.out.print(elem + " -> ");
        visited.add(elem);
        q.add(elem);

        while (!q.isEmpty()) {
            elem = q.remove();
            for (int v : graph.get(elem)) {
                if (!visited.contains(v)) {
                    System.out.print(v + " -> ");
                    visited.add(v);
                    q.add(v);
                }
            }
        }
        System.out.println("NULL");
    }

    public boolean isEmpty() {
        return graph.size() == 0;
    }

    public void DFS() {
        if (isEmpty()) {
            System.out.println("Graph Empty.");
            return;
        }
        Stack<Integer> stack = new Stack<Integer>();
        List<Integer> visited = new LinkedList<Integer>();

        int elem = (int) graph.keySet().toArray()[0];
        System.out.print(elem + " -> ");
        visited.add(elem);
        stack.push(elem);

        while (!stack.isEmpty()) {
            elem = stack.pop();
            for (int v : graph.get(elem)) {
                if (!visited.contains(v)) {
                    System.out.print(v + " -> ");
                    visited.add(v);
                    stack.push(v);
                    break;
                }
            }
        }
        System.out.println("NULL");
    }
}
