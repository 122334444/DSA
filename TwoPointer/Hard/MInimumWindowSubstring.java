package TwoPointer.Hard;

public class MInimumWindowSubstring {

    public String minWindow(String s, String t) {
        int n = s.length();
        if (n < t.length())
            return "";

        int freq[] = new int[128];
        for (char ch : t.toCharArray()) {
            freq[ch]++;
        }

        int l = 0, count = t.length();
        int minLen = Integer.MAX_VALUE;
        int st = 0;

        for (int r = 0; r < n; r++) {
            if (freq[s.charAt(r)] > 0) {
                count--;
            }
            freq[s.charAt(r)]--;
            while (count == 0) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    st = l;
                }
                freq[s.charAt(l)]++;
                if (freq[s.charAt(l)] > 0) {
                    count++;
                }
                l++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(st, st + minLen);
    }

    public static void main(String args[]) {

    }
}
