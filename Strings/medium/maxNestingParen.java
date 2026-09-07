package Strings.medium;

public class maxNestingParen {
    public static int maxDepth(String s) {
        int count = 0;
        int max = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
                max = Math.max(max, count);
            } else if (ch == ')') {
                count--;
            }
        }
        return max;
    }

    public static void main(String args[]) {
        String s = "(1+(2*3)+((8)/4))+1";

        System.out.println(maxDepth(s));
    }
}
