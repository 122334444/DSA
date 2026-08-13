package TwoPointer.Hard;

import java.util.HashMap;

public class LongestSubstrWithAtmostKdustinctChars {

    public static int longestSubstr(String s, int k) {
        int n = s.length();
        int l = 0, r = 0, maxLen = 0;

        HashMap<Character, Integer> freq = new HashMap<>();
        while (r < n) {
            char ch = s.charAt(r);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            while (freq.size() > k) {
                char leftChar = s.charAt(l);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }

    public static void main(String args[]) {

    }
}
