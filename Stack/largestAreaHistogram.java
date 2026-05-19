package Stack;

import java.util.*;

public class largestAreaHistogram {

    public static int maxArea(int arr[]) {
        int n = arr.length;

        int lb[] = new int[n];
        Stack<Integer> sl = new Stack<>();
        sl.push(0);
        lb[0] = -1;
        for (int i = 1; i < n; i++) {
            while (sl.size() > 0 && arr[i] < arr[sl.peek()]) {
                sl.pop();
            }
            if (sl.size() == 0) {
                lb[i] = -1;
            } else {
                lb[i] = sl.peek();
            }

            sl.push(i);
        }

        int rb[] = new int[n];
        Stack<Integer> s = new Stack<>();
        rb[n - 1] = n;
        for (int i = n - 2; i > -0; i--) {
            while (s.size() > 0 && arr[i] < arr[s.peek()]) {
                s.pop();
            }
            if (s.size() == 0) {
                rb[i] = n;
            } else {
                rb[i] = s.peek();
            }

            s.push(i);
        }

        int maxAr = 0;
        for (int i = 0; i < n; i++) {
            int w = rb[i] - lb[i] - 1;
            int h = arr[i];
            int ar = h * w;
            maxAr = Math.max(maxAr, ar);
        }
        return maxAr;
    }

    public static void main(String args[]) {
        int arr[] = { 6, 2, 5, 4, 5, 1, 6 };

        int ans = maxArea(arr);
        System.out.println(ans);
    }
}
