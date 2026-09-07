package Stack;

import java.util.*;

public class DuplicateBrackets {

    public static boolean dupliBrackets(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ')') {
                if (s.peek() == '(') {
                    return true;
                } else {
                    while (s.peek() != '(') {
                        s.pop();
                    }
                    s.pop();// to remove the last opening bracket (
                }
            } else {
                s.push(c);
            }
        }
        return false;
    }

    public static void main(String args[]) {
        String str = "((a+b)+(c+d))";
        String str1 = "(a+b)+((c+d))";
        System.out.println(dupliBrackets(str));
        System.out.println(dupliBrackets(str1));
    }
}
