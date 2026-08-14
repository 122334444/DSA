package TwoPointer.Medium;

import java.util.HashMap;
import java.util.Map;

//Given a string s, return the maximum length of a substring such that it contains at most two occurrences of each character.
public class MaxSubstrWithTwoOccurance {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int l = 0, r = 0;
        int len = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (r < n) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            while (map.get(s.charAt(r)) > 2) {
                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);
                l++;
            }
            len = Math.max(len, r - l + 1);
            r++;
        }
        return len;
    }
}
