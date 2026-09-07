package Greedy;

import java.util.Arrays;

public class NonOverlapping {
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int prev = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (prev > intervals[i][0]) {// removal required
                count++;
            } else {
                prev = intervals[i][1];
            }
        }
        return count;
    }

    public static void main(String args[]) {
        int intervals[][] = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };

        System.out.println(eraseOverlapIntervals(intervals));
    }
}
