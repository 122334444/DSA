package Graph;

import java.util.*;

import javax.sql.rowset.spi.SyncResolver;

public class bfs {

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

    public static void bfs(int n, ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for (Edge e : graph[curr]) {
                if (!vis[e.dest]) {
                    vis[e.dest] = true;
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String args[]) {
        int n = 5;
        int paths[][] = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 4 }, { 3, 4 } };
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(graph, paths);
        bfs(n, graph);
    }
}