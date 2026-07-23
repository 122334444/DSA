package Graph;

import java.util.*;

public class StronglyConnectedComponant {

    // A Strongly Connected Component (SCC) is a maximal group of vertices such
    // that:
    // Every vertex can reach every other vertex in the group.

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

    public static void createGraphTranspose(ArrayList<Edge> graph[], int paths[][]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int p[] : paths) {
            int src = p[0];
            int dest = p[1];
            graph[dest].add(new Edge(dest, src));
        }
    }

    private static void topo(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!vis[e.dest]) {
                topo(graph, e.dest, vis, s);
            }
        }

        s.push(curr);
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        vis[curr] = true;
        System.out.print(curr + " ");

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static void kosarajuAlgo(ArrayList<Edge> graph[], int paths[][]) {

        int n = graph.length;

        // Step 1 : Topological order (finish time order)
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                topo(graph, i, vis, s);
            }
        }

        // Step 2 : Create transpose graph
        ArrayList<Edge> transpose[] = new ArrayList[n];
        createGraphTranspose(transpose, paths);

        // Step 3 : DFS according to stack order
        boolean vis2[] = new boolean[n];

        while (!s.isEmpty()) {

            int curr = s.pop();

            if (!vis2[curr]) {
                dfs(transpose, curr, vis2);
                System.out.println();
            }
        }
    }

    public static void main(String args[]) {

        int n = 5;

        int paths[][] = {
                { 0, 2 },
                { 2, 1 },
                { 1, 0 },
                { 0, 3 },
                { 3, 4 }
        };

        ArrayList<Edge> graph[] = new ArrayList[n];

        createGraph(graph, paths);

        System.out.println("Strongly Connected Components:");

        kosarajuAlgo(graph, paths);
    }
}