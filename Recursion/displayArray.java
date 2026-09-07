package Recursion;

public class displayArray {

    public static void dispArr(int arr[], int idx) {
        if (idx == arr.length) {
            return;
        }
        System.out.print(arr[idx] + " ");
        dispArr(arr, idx + 1);
    }

    public static void dispArrRev(int arr[], int idx) {
        if (idx == arr.length) {
            return;
        }

        dispArrRev(arr, idx + 1);
        System.out.print(arr[idx] + " ");
    }

    public static int findMax(int[] arr, int n) {
        // Base case:if only one element is there
        if (n == 1) {
            return arr[0];
        }
        int maxOfRest = findMax(arr, n - 1);
        return Math.max(maxOfRest, arr[n - 1]);
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 3, 10, 2, 3, 4, 15, 7, 6, 5 };
        int n = arr.length;
        dispArr(arr, 0);
        System.out.println();
        dispArrRev(arr, 0);
        System.out.println();
        System.out.println(findMax(arr, n));
    }
}
