package Graph.ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//Leet code 1091

public class ShortestPathInBinaryMat {

    class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    private void createGraph(List<Edge>[] graph, int[][] mat) {
        int n = mat.length;

        for (int i = 0; i < n * n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // Current cell must be 0
                if (mat[i][j] == 1)
                    continue;

                int src = i * n + j;

                for (int k = 0; k < 8; k++) {
                    int ni = i + dr[k];
                    int nj = j + dc[k];

                    if (ni >= 0 && ni < n &&
                            nj >= 0 && nj < n &&
                            mat[ni][nj] == 0) {

                        int dest = ni * n + nj;
                        graph[src].add(new Edge(src, dest));
                    }
                }
            }
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

    public static int dijkstra(List<Edge>[] graph, int src, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        boolean[] vis = new boolean[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            if (vis[curr.node])
                continue;
            vis[curr.node] = true;

            for (Edge e : graph[curr.node]) {
                int v = e.dest;

                // Every edge has weight = 1
                if (dist[curr.node] + 1 < dist[v]) {
                    dist[v] = dist[curr.node] + 1;
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }

        return dist[n - 1] == Integer.MAX_VALUE ? -1 : dist[n - 1] + 1;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (n == 1 && m == 1 && grid[n - 1][m - 1] == 1)
            return -1;
        List<Edge> graph[] = new ArrayList[n * n];
        createGraph(graph, grid);

        return dijkstra(graph, 0, n * n);
    }

    public static void main(String args[]) {
        int grid[][] = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };

    }
}
