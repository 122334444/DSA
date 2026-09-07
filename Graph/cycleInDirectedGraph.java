package Graph;

import java.util.ArrayList;

import Graph.bfs.Edge;

public class cycleInDirectedGraph {

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

        for (int p[] : paths) {
            int src = p[0];
            int dest = p[1];
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
        int n = 5;
        int paths[][] = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 4 }, { 3, 4 } };
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(graph, paths);
    }
}
