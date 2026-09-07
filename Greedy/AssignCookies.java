package Greedy;

import java.util.Arrays;

//LeetCode 455
public class AssignCookies {

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length;
        int m = s.length;
        int l = 0, r = 0;
        while (l < m && r < n) {
            if (g[r] <= s[l]) {
                r++;
            }
            l++;
        }
        return r;
    }

    public static void main(String args[]) {
        int g[] = { 1, 5, 3, 3, 4 };
        int s[] = { 4, 2, 1, 2, 1, 3 };
        System.out.println(findContentChildren(g, s));
    }
}
