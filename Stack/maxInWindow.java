package Stack;

import java.util.*;

public class maxInWindow {

    public static int[] maxIntWin(int arr[], int k) {
        int n = arr.length;

        int nge[] = new int[n];// storing index of the nge

        Stack<Integer> s = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (s.size() > 0 && arr[i] >= arr[s.peek()]) {
                s.pop();
            }
            if (s.size() == 0) {
                nge[i] = -1;
            } else {
                nge[i] = s.peek();
            }
            s.push(i);
        }

        int max[] = new int[n - k + 1];
        int j = 0;
        for (int i = 0; i <= n - k; i++) {
            if (j < i) {
                j = i;
            }

            // jump using nge
            while (nge[j] != -1 && nge[j] < i + k) {
                j = nge[j];
            }

            max[i] = arr[j];
        }
        return max;
    }

    public static void main(String args[]) {
        int arr[] = { 2, 9, 3, 8, 1, 7, 12, 6, 14 };
        int k = 4;

        int ans[] = maxIntWin(arr, k);

        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}
