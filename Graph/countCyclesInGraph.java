package Graph;

import java.util.ArrayList;

public class countCyclesInGraph {

    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int[][] paths) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] f : paths) {
            int src = f[0];
            int dest = f[1];
            graph[src].add(new Edge(src, dest));
        }
    }

    public static int countCycles(ArrayList<Edge>[] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        boolean[] recStack = new boolean[n];

        int[] count = new int[1];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(graph, i, vis, recStack, count);
            }
        }

        return count[0];
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr,
            boolean[] vis,
            boolean[] recStack,
            int[] count) {

        vis[curr] = true;
        recStack[curr] = true;

        for (Edge e : graph[curr]) {
            int next = e.dest;

            if (!vis[next]) {
                dfs(graph, next, vis, recStack, count);
            } else if (recStack[next]) {
                count[0]++;
            }
        }

        recStack[curr] = false;
    }

    public static void main(String[] args) {

        int n = 8;

        int[][] paths = {
                { 0, 1 },
                { 1, 2 },
                { 2, 0 }, // Cycle 1: 0 -> 1 -> 2 -> 0

                { 2, 3 },
                { 3, 4 },
                { 4, 2 }, // Cycle 2: 2 -> 3 -> 4 -> 2

                { 4, 5 },
                { 5, 6 },
                { 6, 4 }, // Cycle 3: 4 -> 5 -> 6 -> 4

                { 6, 7 },
                { 7, 5 }, // Cycle 4: 5 -> 6 -> 7 -> 5

                { 1, 5 },
                { 5, 1 } // Cycle 5: 1 -> 5 -> 1
        };

        ArrayList<Edge>[] graph = new ArrayList[n];

        createGraph(graph, paths);

        System.out.println(countCycles(graph));
    }
}