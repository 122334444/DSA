
class SelectionSort {

    public static void slelection(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find minimum element in unsorted part
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap minimum with first element
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String args[]) {
        int arr[] = {1, 4, 3, 2, 5, 7, 6};
        slelection(arr);

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
