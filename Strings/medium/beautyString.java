package Strings.medium;

///leetcode 1781
public class beautyString {
    public int beautySum(String s) {
        int n = s.length();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int freq[] = new int[26];
            for (int j = i; j < n; j++) {
                int idx = s.charAt(j) - 'a';
                freq[idx]++;
                int beauty = maxCount(freq) - minCount(freq);
                sum += beauty;
            }
        }
        return sum;
    }

    private int maxCount(int freq[]) {
        int m = Integer.MIN_VALUE;
        for (int x : freq) {
            m = Math.max(m, x);
        }
        return m;
    }

    private int minCount(int freq[]) {
        int m = Integer.MAX_VALUE;
        for (int x : freq) {
            if (x != 0)
                m = Math.min(m, x);
        }
        return m;
    }
}
