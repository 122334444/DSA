package Graph.ShortestPath;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//leetcode 1334
public class CitiesWithSmallestNumOfNeighbours {
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

    static class Pair {
        int node;
        int dist;

        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public void createGraph(List<Edge> graph[], int n, int[][] edges) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            int src = e[0], dest = e[1], wt = e[2];
            graph[src].add(new Edge(src, dest, wt));
            graph[dest].add(new Edge(dest, src, wt));// to make the graph un-directed
        }
    }

    public static int[] dijkstra(List<Edge> graph[], int src, int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.add(new Pair(src, 0));
        int dist[] = new int[n];
        // initialisation
        for (int i = 0; i < n; i++) {
            if (i != src)
                dist[i] = Integer.MAX_VALUE;
        }
        boolean vis[] = new boolean[n];
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.node]) {
                vis[curr.node] = true;
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    if (dist[v] > dist[u] + e.wt) {// normalisation
                        dist[v] = dist[u] + e.wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        return dist;
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<Edge> graph[] = new ArrayList[n];
        createGraph(graph, n, edges);

        int minDistMat[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            minDistMat[i] = dijkstra(graph, i, n);
        }

        int neighCount[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (minDistMat[i][j] <= distanceThreshold) {
                    neighCount[i]++;
                }
            }
        }
        int min = neighCount[0];
        for (int num : neighCount) {
            if (min > num) {
                min = num;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (neighCount[i] == min) {
                return i;
            }
        }

        return -1;// never come

    }
}
