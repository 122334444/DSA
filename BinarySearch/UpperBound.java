package BinarySearch;

public class UpperBound {

    public static int upperBound(int arr[], int x) {// need less or equal
        int n = arr.length;
        int l = 0, r = n - 1;
        int ans = n;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] > x) {
                ans = mid;
                r = mid - 1;
            } else {

                l = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 6, 6, 7, 8 };
        System.out.println(upperBound(arr, 6));
    }
}
