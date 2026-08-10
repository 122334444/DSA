package TwoPointer.Medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubWithNoReapetChar {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0, r = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (r < n) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }

    public static void main(String args[]) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
