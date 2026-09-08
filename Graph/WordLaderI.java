
import java.util.*;

class WordLaderI {

    class Pair {

        String first;
        int second;

        Pair(String first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int ladderLength(String st, String end, List<String> list) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(st, 1));
        Set<String> set = new HashSet<>();
        for (String s : list) {
            set.add(s);
        }
        set.remove(st);

        while (!q.isEmpty()) {
            String word = q.peek().first;
            int step = q.peek().second;
            q.remove();
            if (word.equals(end)) {
                return step;
            }

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char repArr[] = word.toCharArray();
                    repArr[i] = ch;
                    String repWord = new String(repArr);

                    if (set.contains(repWord)) {
                        set.remove(repWord);
                        q.add(new Pair(repWord, step + 1));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String args[]) {

    }
}
