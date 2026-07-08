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

            // Move i until element greater than pivot
            while (i <= high - 1 && arr[i] <= pivot) {
                i++;
            }

            // Move j until element smaller than or equal to pivot
            while (j >= low + 1 && arr[j] > pivot) {
                j--;
            }

            if (i < j) {
                swap(arr, i, j);
            }
        }

        // Place pivot at its correct position
        swap(arr, low, j);

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

    // Print array
    private static void printArray(int arr[]) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {

        int arr[] = { 4, 6, 2, 5, 7, 9, 1, 3 };

        System.out.println("Before Sorting:");
        printArray(arr);

        qs(arr, 0, arr.length - 1);

        System.out.println("After Sorting:");
        printArray(arr);
    }
}