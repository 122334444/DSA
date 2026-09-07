package Graph;
//547. Number of Provinces(leet code)

/// BASICALLY NUMBER OF DISCONNECTED GRAPHS-. HELPFULL
import java.util.*;

public class numberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                adj.get(i).add(isConnected[i][j]);
            }
        }
        return provinces(adj, v);
    }

    private int provinces(List<List<Integer>> adj, int v) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (adj.get(i).get(j) == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int vis[] = new int[v];
        int count = 0;
        for (int i = 0; i < v; i++) {
            if (vis[i] == 0) {// not visited
                count++;
                dfs(i, adjList, vis);
            }
        }
        return count;
    }

    private void dfs(int node, List<List<Integer>> adjList, int vis[]) {
        vis[node] = 1;// true
        for (Integer it : adjList.get(node)) {
            if (vis[it] == 0) {
                dfs(it, adjList, vis);
            }
        }
    }

    public static void main(String args[]) {
        numberOfProvinces obj = new numberOfProvinces();
        int isConnected[][] = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        System.out.println(obj.findCircleNum(isConnected));
    }
}
