package Graph;

import java.util.*;

public class DijkstrasAlgo {

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

    public static void createGraph(int paths[][], ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int p[] : paths) {
            int s = p[0], d = p[1], w = p[2];
            graph[s].add(new Edge(s, d, w));
        }
    }

    static class Pair {
        int node;
        int dist;

        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static int[] dijkstra(ArrayList<Edge> graph[], int src, int n) {
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        boolean vis[] = new boolean[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.node]) {
                vis[curr.node] = true;
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = e.src, v = e.dest, wt = e.wt;
                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String args[]) {
        int paths[][] = { { 0, 1, 2 }, { 1, 2, 1 }, { 0, 2, 4 }, { 1, 3, 7 }, { 2, 4, 3 }, { 4, 3, 2 }, { 3, 5, 1 },
                { 4, 5, 5 } };
        int n = 6;// number of nodes
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(paths, graph);
        int dist[] = dijkstra(graph, 0, n);
        for (int i = 0; i < dist.length; i++) {
            System.out.println("Distance of " + i + " from source is " + dist[i]);
        }
    }
}