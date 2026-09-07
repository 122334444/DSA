package TwoPointer.Medium;

//leetcode 1358
public class NUmOfSubsContainingThreeChars {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int freq[] = new int[26];
        int l = 0, r = 0;
        int ans = 0;
        while (r < n) {
            freq[s.charAt(r) - 'a']++;
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                ans += (n - r);
                freq[s.charAt(l) - 'a']--;
                l++;
            }
            r++;
        }
        return ans;
    }
}
