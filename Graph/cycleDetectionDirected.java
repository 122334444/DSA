package Graph;

import java.util.*;

public class cycleDetectionDirected {
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

    public static boolean cycleDetectionDirected(ArrayList<Edge> graph[], int curr, boolean vis[], boolean recStack[]) {
        vis[curr] = true;
        recStack[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (recStack[e.dest] == true) {
                return true;
            } else if (!vis[e.dest]) {
                boolean a = cycleDetectionDirected(graph, e.dest, vis, recStack);
                if (a)
                    return true;
            }
        }
        recStack[curr] = false;
        return false;
    }

    public static void main(String args[]) {
        int paths[][] = { { 1, 0 }, { 0, 2 }, { 2, 3 }, { 3, 0 } };
        int n = 4;
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(paths, graph);
        boolean vis[] = new boolean[n];
        boolean recStack[] = new boolean[n];
        System.out.println(cycleDetectionDirected(graph, 0, vis, recStack));
    }
}