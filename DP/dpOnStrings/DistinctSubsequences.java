
import java.util.*;
//leetcode : 940

class DistinctSubsequences {

    public static int distinctSubseqII(String s) {
        int n = s.length();
        int MOD = 1_000_000_007;

        int dp[] = new int[n + 1];
        dp[0] = 1;

        Map<Character, Integer> map = new HashMap<>();//to trck last occurance 
        for (int i = 1; i <= n; i++) {

            dp[i] = (2 * dp[i - 1]) % MOD;
            char ch = s.charAt(i - 1);
            if (map.containsKey(ch)) {
                int j = map.get(ch);
                dp[i] = (dp[i] - dp[j - 1] + MOD) % MOD;
            }
            map.put(ch, i);
        }
        return (int) (dp[n] - 1 + MOD) % MOD;
    }

    public static void main(String args[]) {
        String s = "abcbac";
        System.out.println(distinctSubseqII(s));
    }
}
