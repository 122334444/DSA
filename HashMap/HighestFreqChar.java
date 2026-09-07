package HashMap;

import java.util.*;
import java.util.Map.Entry;

public class HighestFreqChar {

    public static void highFreqChar(String s) {
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

    public static void getCommonElements(int arr1[], int arr2[]) {
        Set<Integer> hs = new HashSet<>();
        for (int x : arr1) {
            hs.add(x);
        }
        Set<Integer> hs2 = new HashSet<>();
        for (int x : arr2) {
            hs2.add(x);
        }

        for (int x : hs2) {
            if (hs.contains(x))
                System.out.print(x + " ");
        }
    }

    public static void getCommonElements2(int arr1[], int arr2[]) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int x : arr1) {
            map1.put(x, map1.getOrDefault(x, 0) + 1);
        }

        Map<Integer, Integer> map2 = new HashMap<>();
        for (int x : arr2) {
            map2.put(x, map2.getOrDefault(x, 0) + 1);
        }

        for (Entry<Integer, Integer> e : map1.entrySet()) {
            int k = e.getKey();
            int v = e.getValue();// freq
            if (map2.containsKey(k)) {
                for (int i = 0; i < Math.min(v, map2.get(k)); i++) {
                    System.out.print(k + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        String s = "abcbbsbcbdbfgh";

        int arr1[] = { 1, 2, 2, 1, 2, 3, 4, 5 };
        int arr2[] = { 1, 2, 3, 4, 5, 2, 6, 7 };
        getCommonElements(arr1, arr2);

        getCommonElements2(arr1, arr2);
    }
}