package Greedy;

import java.util.Arrays;

public class minPlatformReq {
    public static int findPlatform(int arr[], int dep[]) {

        Arrays.sort(arr);
        Arrays.sort(dep);

        int n = arr.length;

        int i = 1, j = 0;
        int plat = 1;
        int ans = 1;

        while (i < n && j < n) {

            if (arr[i] <= dep[j]) {
                plat++;
                i++;
            } else {// if any train departed -> paltform free
                plat--;
                j++;
            }

            ans = Math.max(ans, plat);
        }

        return ans;
    }

    public static void main(String args[]) {

        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };

        System.out.println(findPlatform(arr, dep));
    }
}
