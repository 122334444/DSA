package HashMap;

import java.util.*;

public class longestConsecutiveSeq {
    public static void main(String args[]) {
        int arr[] = { 10, 5, 9, 1, 11, 8, 6, 15, 3, 12, 2 };

        Map<Integer, Boolean> map = new HashMap<>();
        for (int x : arr) {
            map.put(x, true);
        }

        for (int x : arr) {
            if (map.containsKey(x - 1)) {
                map.put(x, false);
            }
        }

        int msp = 0;// minimum start point
        int max = 0;// max len of cont seq
        for (int x : arr) {
            if (map.get(x) == true) {
                int tl = 1;// temporary length
                int tsp = x;// temp start point
                while (map.containsKey(tl + tsp)) {
                    tl++;
                }
                if (tl > max) {
                    max = tl;
                    msp = tsp;
                }

            }
        }

        for (int i = 0; i < max; i++) {
            System.out.print(msp + i + " ");
        }
    }
}
