package Graph;

import java.util.ArrayList;

import Graph.bfs.Edge;

public class dfs {

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

    public static void dfs(int n, ArrayList<Edge> graph[], int curr, boolean vis[]) {
        System.out.print(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(n, graph, e.dest, vis);
                // vis[e.dest] = true;
            }
        }
    }

    public static void main(String args[]) {
        int n = 5;
        int paths[][] = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 4 }, { 3, 4 } };
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(graph, paths);
        dfs(n, graph, 0, new boolean[n]);
    }
}
