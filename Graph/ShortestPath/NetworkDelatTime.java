package Graph.ShortestPath;

//leet code 743

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelatTime {
    class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    private void createGraph(int paths[][], List<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int p[] : paths) {
            int s = p[0], d = p[1], w = p[2];
            graph[s].add(new Edge(s, d, w));
        }
    }

    class Pair {
        int node;
        int dist;

        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    private int[] dijkstra(List<Edge> graph[], int src) {
        int n = graph.length;
        int dist[] = new int[n];
        boolean vis[] = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        // vis[src]=true;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.node]) {
                vis[curr.node] = true;
                for (Edge e : graph[curr.node]) {
                    int u = e.src, v = e.dest, w = e.wt;
                    if (dist[v] > dist[u] + w) {
                        dist[v] = dist[u] + w;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        return dist;
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<Edge> graph[] = new ArrayList[n + 1];
        createGraph(times, graph);

        int arr[] = dijkstra(graph, k);

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (arr[i] == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, arr[i]);
        }
        return ans;
    }
}
