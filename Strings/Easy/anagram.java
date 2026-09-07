package Strings.Easy;

import java.util.Arrays;

public class anagram {
    public boolean isAnagram(String s, String t) {
        // if (s.length() == t.length()) {
        // char[] sArray = s.toCharArray();
        // char[] tArray = t.toCharArray();
        // Arrays.sort(sArray);
        // Arrays.sort(tArray);
        // return Arrays.equals(sArray, tArray);
        // } else {
        // return false;
        // }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }
}
