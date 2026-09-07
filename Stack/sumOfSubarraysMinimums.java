package Stack;

import java.util.*;

public class sumOfSubarraysMinimums {

    // brute force O(n^3) -> generate all subarrays & O(n^2) -> check at each steps

    // public int sumSubarrayMins(int[] arr) {
    // int n=arr.length;
    // int mod=(int)1e9+7;
    // int sum=0;
    // for(int i=0;i<n;i++){
    // int min=arr[i];
    // for(int j=i;j<n;j++){
    // min=Math.min(min,arr[j]);
    // sum=(sum+min)%mod;
    // }
    // }
    // return sum;
    // }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = 1000000007;

        int[] psee = previousSmallerOrEqual(arr);
        int[] nse = nextSmaller(arr);

        long ans = 0;
        for (int i = 0; i < n; i++) {
            long left = i - psee[i];
            long right = nse[i] - i;
            long contribution = (left * right * arr[i]) % mod;
            ans = (ans + contribution) % mod;
        }
        return (int) ans;
    }

    // Previous Smaller or Equal Element
    private int[] previousSmallerOrEqual(int[] arr) {
        int n = arr.length;
        int[] psee = new int[n];

        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (s.size() > 0 && arr[s.peek()] > arr[i]) {
                s.pop();
            }
            if (s.size() == 0) {
                psee[i] = -1;
            } else {
                psee[i] = s.peek();
            }
            s.push(i);
        }
        return psee;
    }

    // Next Smaller Element
    private int[] nextSmaller(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (s.size() > 0 && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.size() == 0) {
                nse[i] = n;
            } else {
                nse[i] = s.peek();
            }
            s.push(i);
        }
        return nse;
    }

    public static void main(String args[]) {
        int arr[] = { 3, 1, 2, 4 };
    }
}
