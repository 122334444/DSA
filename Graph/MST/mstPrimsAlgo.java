package Graph;

//MINIMUM SPANNING TREE(Prims Algorithm)
import java.util.*;

public class mstPrimsAlgo {

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
        int wt;

        public Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[], int paths[][]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int f[] : paths) {
            int src = f[0], dest = f[1], wt = f[2];
            graph[src].add(new Edge(src, dest, wt));
            graph[dest].add(new Edge(dest, src, wt));
        }
    }

    public static void primsAlgo(ArrayList<Edge> graph[], int n) {
        boolean vis[] = new boolean[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);// ensures minimum weight edge is always at
                                                                            // the top
        pq.add(new Pair(0, 0));
        int finalCost = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (!vis[curr.node]) {
                vis[curr.node] = true;
                finalCost += curr.wt;

                for (Edge e : graph[curr.node]) {
                    if (!vis[e.dest]) {
                        pq.add(new Pair(e.dest, e.wt));
                    }
                }
            }
        }
        System.out.println("Minimum Cost: " + finalCost);
    }

    // TC -> O(ElogV) where E is the number of edges and V is the number of vertices

    public static void main(String args[]) {
        int paths[][] = {
                { 0, 1, 10 },
                { 0, 2, 15 },
                { 1, 3, 12 },
                { 2, 3, 10 },
                { 1, 2, 5 },
                { 3, 4, 2 }
        };
        int n = 5;
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(graph, paths);
        primsAlgo(graph, n);
    }
}
