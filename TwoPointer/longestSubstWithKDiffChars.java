package TwoPointer;

import java.util.*;

public class longestSubstWithKDiffChars {

    public static int fxn(String s, int k) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            map.clear();
            for (int j = i; j < n; j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                if (map.size() <= k) {
                    max = Math.max(max, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String args[]) {
        String str = "abcacchdfghacvfgdsddsasd";
        int k = 5;

        System.out.println(fxn(str, k));
    }
}
