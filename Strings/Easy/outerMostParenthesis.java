package Strings.Easy;

//LeetCode 1021 -> Easy

public class outerMostParenthesis {

    public String removeOuterParentheses(String s) {
        int n = s.length();
        if (n <= 2)
            return "";
        char c[] = s.toCharArray();

        StringBuilder sb = new StringBuilder();

        int open = 1;

        for (int i = 1; i < n; i++) {
            if (c[i] == '(') {
                open++;
                if (open > 1)
                    sb.append('(');
            } else {
                if (open > 1)
                    sb.append(')');
                open--;
            }
        }

        return sb.toString();
    }

    public static void main(String args[]) {

    }
}
