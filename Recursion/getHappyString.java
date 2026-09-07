package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//LEETCODE 1415. The k-th Lexicographical String of All Happy Strings of Length n

public class getHappyString {
    public String HappyString(int n, int k) {
        int size = (int) (3 * Math.pow(2, n - 1));
        if (k > size)
            return "";

        char[] ch = { 'a', 'b', 'c' };
        List<String> ls = new ArrayList<>();
        solve(n, new String(), ch, ls);

        Collections.sort(ls);
        return ls.get(k - 1);
    }

    private void solve(int n, String curr, char[] ch, List<String> set) {
        if (n == curr.length()) {
            set.add(curr);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (curr.length() == 0 || curr.charAt(curr.length() - 1) != ch[i]) {
                solve(n, curr + ch[i], ch, set);
            }
        }
    }

    public static void main(String args[]) {
        getHappyString g = new getHappyString();
        System.out.println(g.HappyString(3, 9));
    }
}
