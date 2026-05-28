package TwoPointer;

import java.util.*;

public class longestSubstWithKDiffChars {
    // TC -> O(N^2)
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

    // Optimal -> O(N)
    public static int optimal(String s, int k) {
        int n = s.length();
        int l = 0, r = 0;

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;

        while (r < n) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);

            while (map.size() > k) {
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) - 1);
                if (map.get(s.charAt(l)) == 0)
                    map.remove(s.charAt(l));
                l++;
            }

            max = Math.max(max, r - l + 1);

            r++;
        }
        return max;
    }

    public static void main(String args[]) {
        String str = "abcacchdfghacvfgdsddsasd";
        int k = 5;

        System.out.println(optimal(str, k));
    }
}
