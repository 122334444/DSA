package Heaps;

import java.util.*;

public class KsortedArray {
    public static void main(String args[]) {
        int arr[] = { 2, 3, 1, 4, 6, 7, 5, 8, 9 };// elements are shifted k back or forward
        int k = 2;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i <= k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k + 1; i < arr.length; i++) {
            System.out.print(pq.remove() + " ");
            pq.add(arr[i]);
        }

        while (pq.size() > 0) {
            System.out.print(pq.remove() + " ");
        }
        System.out.println();
    }
}
