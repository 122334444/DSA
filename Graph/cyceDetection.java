package Graph;

import java.util.*;

public class cyceDetection {

    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[], int paths[][]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int f[] : paths) {
            int src = f[0], dest = f[1];
            graph[src].add(new Edge(src, dest));
        }
    }

    // DIRECTED GRAPH
    public static boolean cycleDetectionDirected(ArrayList<Edge> graph[], boolean vis[], int curr, boolean recStack[]) {
        vis[curr] = true;
        recStack[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (recStack[e.dest] == true) {
                return true;
            } else if (!vis[e.dest]) {
                if (cycleDetectionDirected(graph, vis, e.dest, recStack)) {
                    return true;
                }
            }
        }
        recStack[curr] = false;
        return false;
    }

    // UNDIRECTED GRAPH
    public static boolean cycleDetectionUndirected(ArrayList<Edge> graph[], boolean vis[], int curr, int parent) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                if (cycleDetectionUndirected(graph, vis, e.dest, curr)) {
                    return true;
                }
            } else if (e.dest != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int n = 5;
        int paths[][] = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 0 } };
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(graph, paths);
        boolean vis[] = new boolean[n];
        boolean recStack[] = new boolean[n];
        System.out.println(cycleDetectionDirected(graph, vis, 0, recStack));

        boolean vis2[] = new boolean[n];
        System.out.println(cycleDetectionUndirected(graph, vis2, 0, -1));

    }
}
