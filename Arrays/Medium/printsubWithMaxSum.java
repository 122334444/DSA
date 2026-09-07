package Arrays.Medium;

public class printsubWithMaxSum {
    public static void main(String args[]) {
        int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        int n = arr.length;

        int st = 0;
        int ansSt = -1, ansEnd = -1;

        int sum = 0, max = 0;

        for (int i = 0; i < n; i++) {
            if (sum == 0)
                st = i;
            sum += arr[i];
            if (sum > max) {
                max = sum;
                ansSt = st;
                ansEnd = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }

        System.out.println(ansSt + " " + "->" + " " + ansEnd);
    }
}
