package Graph;

import java.util.*;

public class BipartiteGraph {

    class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    private void createGraph(List<Edge> graph[], int paths[][]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < paths.length; i++) {
            int s = i;
            for (int j = 0; j < paths[i].length; j++) {
                graph[s].add(new Edge(s, paths[i][j]));
                graph[paths[i][j]].add(new Edge(paths[i][j], s));
            }
        }
    }

    private boolean dfs(List<Edge> graph[], int curr, int color[], int currCol) {
        color[curr] = currCol;
        for (Edge e : graph[curr]) {
            if (color[e.dest] == -1) {
                if (!dfs(graph, e.dest, color, 1 - currCol)) {
                    return false;
                }
            } else if (color[e.dest] == currCol) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] paths) {
        int n = paths.length;
        List<Edge> graph[] = new ArrayList[n];
        createGraph(graph, paths);

        int color[] = new int[n];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfs(graph, i, color, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {

    }
}
