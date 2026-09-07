package Graph.MST;

import java.util.ArrayList;

//leet code 1319. Number of Operations to Make Network Connected
public class MakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        boolean[] vis = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                components++;
                dfs(i, graph, vis);
            }
        }
        return components - 1;
    }

    private void dfs(int node, ArrayList<Integer>[] graph, boolean[] vis) {
        vis[node] = true;
        for (int next : graph[node]) {
            if (!vis[next]) {
                dfs(next, graph, vis);
            }
        }
    }
}
