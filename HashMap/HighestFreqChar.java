package HashMap;

import java.util.HashMap;
import java.util.Map.Entry;

public class HighestFreqChar {
    public static void main(String[] args) {
        String s = "abcbbsbcbdbfgh";

        HashMap<Character, Integer> freq = new HashMap<>();

        // Count frequencies
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (freq.containsKey(ch)) {
                freq.put(ch, freq.get(ch) + 1);
            } else {
                freq.put(ch, 1);
            }
        }

        // Find highest frequency character
        char maxChar = '\0';
        int maxFreq = 0;

        for (Entry<Character, Integer> e : freq.entrySet()) {
            if (e.getValue() > maxFreq) {
                maxFreq = e.getValue();
                maxChar = e.getKey();
            }
        }

        System.out.println("Highest Frequency Character: " + maxChar);
        System.out.println("Frequency: " + maxFreq);
    }
}