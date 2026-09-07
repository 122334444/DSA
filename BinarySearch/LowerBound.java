package BinarySearch;

public class LowerBound {

    public static int lowerBound(int arr[], int x) {
        int n = arr.length;
        int l = 0, r = n - 1;
        int ans = n;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= x) {
                ans = mid;// may be an answer
                r = mid - 1;
            } else {
                l = mid + 1;// cant be ans
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 6, 6, 7, 8 };
        System.out.println(lowerBound(arr, 6));
    }
}
