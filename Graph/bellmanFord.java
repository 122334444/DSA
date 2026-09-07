package Graph;

import java.util.*;

public class bellmanFord {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[], int paths[][]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int p[] : paths) {
            int src = p[0];
            int dest = p[1];
            int wt = p[2];

            graph[src].add(new Edge(src, dest, wt));
        }
    }

    public static int[] bellman(ArrayList<Edge> graph[], int src, int n) {
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < graph.length; j++) {
                for (Edge e : graph[j]) {
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String args[]) {
        int paths[][] = {
                { 0, 1, 2 },
                { 0, 2, 4 },
                { 1, 2, -4 },
                { 2, 3, 2 },
                { 3, 4, 4 },
                { 4, 1, -1 }
        };
        int n = 5;
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(graph, paths);
        int src = 0;
        int dist[] = bellman(graph, src, n);
        for (int d : dist) {
            System.out.print(d + " ");
        }
    }
}
