package Graph.BFSandDFS;

import java.util.*;

public class wordLadder1 {
    class Pair {
        String first;
        int second;

        public Pair(String first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        Set<String> st = new HashSet<String>();

        for (int i = 0; i < wordList.size(); i++) {
            st.add(wordList.get(i));
        }
        st.remove(beginWord);

        while (!q.isEmpty()) {
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            if (word.equals(endWord))
                return steps;

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char repCharArr[] = word.toCharArray();
                    repCharArr[i] = ch;
                    String repWord = new String(repCharArr);
                    if (st.contains(repWord)) {
                        st.remove(repWord);
                        q.add(new Pair(repWord, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}
