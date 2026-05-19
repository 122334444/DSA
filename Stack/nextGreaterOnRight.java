package Stack;

import java.util.*;

public class nextGreaterOnRight {

    public static int[] nexGreaterRight(int arr[]) {
        int n = arr.length;
        int ans[] = new int[n];

        Stack<Integer> s = new Stack<>();
        ans[n - 1] = -1;

        for (int i = n - 2; i >= 0; i--) {
            while (s.size() > 0 && arr[i] >= s.peek()) {// jab koi bada mil jayega tab ruk jayga aur usko assogn
                                                        // kar/dega
                s.pop();
            }

            if (s.size() == 0) {
                ans[i] = -1;
            } else {
                ans[i] = s.peek();
            }
            s.push(arr[i]);
        }
        return ans;
    }

    public static void main(String args[]) {
        int arr[] = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };

        int nge[] = nexGreaterRight(arr);

        for (int i = 0; i < nge.length; i++) {
            System.out.print(nge[i] + " ");
        }
    }
}
