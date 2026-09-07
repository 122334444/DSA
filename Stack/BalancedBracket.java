package Stack;

import java.util.*;

public class BalancedBracket {

    public static boolean balanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.peek() != '(' || stack.size() == 0)
                    return false;
                stack.pop();
            } else if (ch == '}') {
                if (stack.peek() != '{' || stack.size() == 0)
                    return false;
                stack.pop();
            } else if (ch == ']') {
                if (stack.peek() != '[' || stack.size() == 0)
                    return false;
                stack.pop();
            }
        }
        return stack.size() == 0;
    }

    public static void main(String args[]) {
        String s = "[(a+b)+{(c+d)*(e/f)}]";
        String s1 = "[(a+b)+{(c+d)*(e/f)]}";

        System.out.println(balanced(s));
        System.out.println(balanced(s1));
    }
}
