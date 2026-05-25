package Stack;

import java.util.*;

//LEETCODE 402 -> return the smallest possible integer after removing k digits from num(String)

public class removeKdigits {
    public static String removeK_digits(String num, int k) {
        int n = num.length();
        if (n == k)
            return "0";
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && k > 0 && (s.peek() - '0') > (num.charAt(i) - '0')) {
                s.pop();
                k--;
            }
            s.push(num.charAt(i));
        }

        while (k > 0) {
            s.pop();
            k--;
        }

        StringBuilder res = new StringBuilder();
        while (!s.isEmpty()) {
            res.append(s.pop());
        }
        res.reverse();

        while (res.length() > 0 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }

        if (res.length() == 0) {
            return "0";
        }
        return res.toString();
    }
}
