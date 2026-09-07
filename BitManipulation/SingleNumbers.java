package BitManipulation;

public class SingleNumbers {
    public int[] singleNumber(int[] nums) {
        int xor = 0;

        // XOR of the two unique numbers
        for (int num : nums) {
            xor ^= num;
        }

        // Get a set bit where the two numbers differ
        int bit = xor & -xor;

        int a = 0, b = 0;

        // Divide numbers into two groups based on that bit
        for (int num : nums) {
            if ((num & bit) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        // Return in ascending order
        if (a < b) {
            return new int[] { a, b };
        } else {
            return new int[] { b, a };
        }
    }
}

// Given an array nums of length n, every integer in the array appears twice
// except for two integers. Identify and return the two integers that appear
// only once in the array. Return the two numbers in ascending order.
