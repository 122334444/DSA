package Stack;

import java.util.*;

public class mergeInterval {

    public static class Pair implements Comparable<Pair> {
        int st;
        int end;

        Pair(int st, int end) {
            this.st = st;
            this.end = end;
        }

        public int compareTo(Pair other) {
            if (this.st != other.st) {
                return this.st - other.st;
            } else {
                return this.end - other.end;
            }
        }
    }

    public static int[][] merge(int arr[][]) {
        Pair[] pairs = new Pair[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }

        Arrays.sort(pairs);

        Stack<Pair> s = new Stack<>();
        for (int i = 0; i < pairs.length; i++) {
            if (i == 0) {
                s.push(pairs[i]);
            } else {
                Pair top = s.peek();
                if (pairs[i].st > top.end) {
                    s.push(pairs[i]);
                } else {
                    top.end = Math.max(top.end, pairs[i].end);
                }
            }
        }
        int[][] ans = new int[s.size()][2];

        for (int i = s.size() - 1; i >= 0; i--) {
            Pair p = s.pop();
            ans[i][0] = p.st;
            ans[i][1] = p.end;
        }

        return ans;
    }

    public static void main(String args[]) {
        int ranges[][] = { { 22, 28 }, { 1, 8 }, { 25, 27 }, { 14, 19 }, { 27, 30 }, { 5, 12 } };

        int ans[][] = merge(ranges);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i][0] + " ");
            System.out.println(ans[i][1]);
        }
    }
}
