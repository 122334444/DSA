package Stack;

import java.util.*;

//LEETCODE 735

public class asteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        for (int a : asteroids) {
            boolean destroyed = false;
            while (s.size() > 0 && s.peek() > 0 && a < 0) {
                if (Math.abs(a) > s.peek()) {// smaller
                    s.pop();
                } else if (Math.abs(a) == s.peek()) {// equal
                    s.pop();
                    destroyed = true;
                    break;
                } else {// bigger
                    destroyed = true;
                    break;
                }
            }
            if (!destroyed) {
                s.push(a);
            }
        }

        int ans[] = new int[s.size()];
        for (int i = s.size() - 1; i >= 0; i--) {
            ans[i] = s.peek();
            s.pop();
        }
        return ans;
    }

    public static void main(String args[]) {

    }
}
