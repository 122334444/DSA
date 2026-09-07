package SortingTechniques;

public class quickSort {

    // Swap two elements
    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Partition function
    private static int f(int arr[], int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (i <= high - 1 && arr[i] <= pivot) {// Move i until element greater than pivot
                i++;
            }
            while (j >= low + 1 && arr[j] > pivot) {// Move j until element smaller than or equal to pivot
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);// Place pivot at its correct position
        return j;
    }

    // Quick Sort
    private static void qs(int arr[], int low, int high) {
        if (low < high) {
            int pIdx = f(arr, low, high);
            qs(arr, low, pIdx - 1);
            qs(arr, pIdx + 1, high);
        }
    }

    public static void main(String args[]) {

        int arr[] = { 4, 6, 2, 5, 7, 9, 1, 3 };
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
        qs(arr, 0, arr.length - 1);
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}