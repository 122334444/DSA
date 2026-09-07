package Heaps;

import java.util.*;

public class KlargestNums {
    public static void main(String args[]) {
        int arr[] = { 1, 3, 2, 4, 5, 6, 79, 76, 5, 6 };
        int k = 3;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] > pq.peek()) {
                pq.remove();
                pq.add(arr[i]);
            }
        }

        while (!pq.isEmpty()) {
            System.out.print(pq.remove() + " ");
        }
    }
}
