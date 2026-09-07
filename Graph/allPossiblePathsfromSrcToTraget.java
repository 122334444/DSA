package Graph;

import java.util.*;

class allPossiblePathsfromSrcToTarget {

    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    private static void createGraph(int paths[][], ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int f[] : paths) {
            int s = f[0], d = f[1];
            graph[s].add(new Edge(s, d));
            graph[d].add(new Edge(d, s));
        }
    }

    private static void allPath(ArrayList<Edge> graph[], int curr, int target, boolean vis[], String path) {
        if (curr == target) {
            System.out.println(path);
            return;
        }
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                allPath(graph, e.dest, target, vis, path + "->" + e.dest);
            }
        }
        vis[curr] = false;
    }

    private void allPathV2(List<Edge> graph[], int curr, int tar, boolean vis[], List<Integer> ls,
            List<List<Integer>> paths) {
        vis[curr] = true;
        ls.add(curr);
        if (curr == tar) {
            paths.add(new ArrayList<>(ls));
        }
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {

                allPathV2(graph, e.dest, tar, vis, ls, paths);

            }
        }

        ls.remove(ls.size() - 1);
        vis[curr] = false;
    }

    public static void main(String[] args) {
        int n = 5;
        int paths[][] = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 4 }, { 3, 4 } };

        ArrayList<Edge> graph[] = new ArrayList[n];
        boolean vis[] = new boolean[n];
        createGraph(paths, graph);
        allPath(graph, 2, 4, vis, "2");
    }
}