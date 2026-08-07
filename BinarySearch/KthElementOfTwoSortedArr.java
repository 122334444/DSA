package BinarySearch;

public class KthElementOfTwoSortedArr {

    public static int kthElement(int arr1[], int arr2[], int k) {// median of 2 sorted elements is related to this

        int i = 0, n = arr1.length;
        int j = 0, m = arr2.length;
        int count = 0;

        while (i < n || j < m) {
            int val;
            if (i == n) {
                val = arr2[j];
                j++;
            } else if (j == m) {
                val = arr1[i];
                i++;
            } else if (arr1[i] <= arr2[j]) {
                val = arr1[i];
                i++;
            } else {
                val = arr2[j];
                j++;
            }
            count++;// count shld increase in all casses
            if (count == k) {
                return val;
            }
        }
        return -1;// invalid
    }

    public static void main(String args[]) {
        int arr1[] = { 1, 4, 5, 7, 9, 12 };
        int arr2[] = { 2, 3, 6, 10, 15 };
        int k = 5;
        System.out.println(kthElement(arr1, arr2, k));
    }
}
