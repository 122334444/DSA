package Graph.TopologicalSorting;

import java.util.*;

public class AlienDictionary {

    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // Graph Creation
    static void createGraph(String[] words, ArrayList<Edge>[] graph) {

        for (int i = 0; i < 26; i++) {
            graph[i] = new ArrayList<>();
        }

        boolean[][] added = new boolean[26][26];

        for (int i = 0; i < words.length - 1; i++) {

            String first = words[i];
            String second = words[i + 1];

            // Invalid case
            if (first.length() > second.length() &&
                    first.startsWith(second)) {
                throw new RuntimeException("Invalid Dictionary");
            }

            int len = Math.min(first.length(), second.length());

            for (int j = 0; j < len; j++) {

                if (first.charAt(j) != second.charAt(j)) {

                    int u = first.charAt(j) - 'a';
                    int v = second.charAt(j) - 'a';

                    if (!added[u][v]) {
                        graph[u].add(new Edge(u, v));
                        added[u][v] = true;
                    }

                    break;
                }
            }
        }
    }

    static boolean dfs(int curr,
            ArrayList<Edge>[] graph,
            boolean[] visited,
            boolean[] pathVisited,
            Stack<Character> st) {

        visited[curr] = true;
        pathVisited[curr] = true;

        for (Edge e : graph[curr]) {

            if (!visited[e.dest]) {

                if (dfs(e.dest, graph, visited, pathVisited, st))
                    return true;

            } else if (pathVisited[e.dest]) {
                return true; // cycle found
            }
        }

        pathVisited[curr] = false;
        st.push((char) (curr + 'a'));

        return false;
    }

    static String topoSort(ArrayList<Edge>[] graph, boolean[] present) {

        boolean[] visited = new boolean[26];
        boolean[] pathVisited = new boolean[26];

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < 26; i++) {

            if (present[i] && !visited[i]) {

                if (dfs(i, graph, visited, pathVisited, st))
                    return "";
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        String[] words = {
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
        };

        ArrayList<Edge>[] graph = new ArrayList[26];

        boolean[] present = new boolean[26];

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                present[ch - 'a'] = true;
            }
        }

        createGraph(words, graph);

        System.out.println(topoSort(graph, present));
    }
}
