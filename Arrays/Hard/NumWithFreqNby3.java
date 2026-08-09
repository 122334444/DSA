package Arrays.Hard;

public class NumWithFreqNby3 {

    public static int repeatedNumber(int[] A) {
        int n = A.length;

        int cand1 = 0, cand2 = 0;// this approach because there would be max 2 numbers with freq greater than N/3
        int count1 = 0, count2 = 0;

        // Find at most two possible candidates
        for (int num : A) {

            if (num == cand1) {
                count1++;
            } else if (num == cand2) {
                count2++;
            } else if (count1 == 0) {
                cand1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                cand2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        } // now after all cond1 and cond2 will be the top 2 most frequent nums

        // Verify candidates
        count1 = 0;
        count2 = 0;

        for (int num : A) {
            if (num == cand1) {
                count1++;
            }
            if (num == cand2) {
                count2++;
            }
        }

        if (count1 > n / 3) {
            return cand1;
        }

        if (count2 > n / 3) {
            return cand2;
        }

        return -1;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 1, 1, 4, 6, 1, 5, 5, 5, 5, 5, 5, 5, 5, 5 };
        System.out.println(repeatedNumber(arr));
    }
}
