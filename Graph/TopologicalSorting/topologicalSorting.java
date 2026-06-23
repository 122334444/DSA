package Graph;

import java.lang.reflect.Array;
import java.util.*;

public class topologicalSorting {

    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(int paths[][], ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int p[] : paths) {
            int src = p[0], dest = p[1];
            graph[src].add(new Edge(src, dest));
        }
    }

    public static void topoSort(ArrayList<Edge> graph[], boolean vis[], int curr, Stack<Integer> s) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topoSort(graph, vis, e.dest, s);
            }
        }
        s.push(curr);
    }

    public static void main(String args[]) {
        int paths[][] = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 3 }, { 3, 4 } };
        int n = 5;// no. of nodes
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(paths, graph);

        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[n];
        topoSort(graph, vis, 0, s);

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }
}
