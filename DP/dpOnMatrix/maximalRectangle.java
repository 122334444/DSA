package DP.dpOnSquare;
//leetcode 85

import java.util.Stack;

public class maximalRectangle {

    class Solution {
        public int maximalRectangle(char[][] mat) {
            int matrix[][] = convertCharMatrixToInt(mat);
            int m = matrix[0].length;
            int ans = 0;
            int arr[] = matrix[0];
            ans = maxRectArea(matrix[0]);
            for (int i = 1; i < matrix.length; i++) {
                int a[] = matrix[i];
                for (int j = 0; j < a.length; j++) {
                    if (a[j] == 1) {
                        arr[j] += a[j];
                    } else {
                        arr[j] = 0;
                    }
                }
                int ar = maxRectArea(arr);
                ans = Math.max(ans, ar);
            }
            return ans;
        }

        private int maxRectArea(int[] heights) {
            int n = heights.length;
            int maxArea = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i <= n; i++) {
                int currentHeight = (i == n) ? 0 : heights[i];

                while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                    int height = heights[stack.pop()];
                    int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                    maxArea = Math.max(maxArea, height * width);
                }
                stack.push(i);
            }
            return maxArea;
        }

        public static int[][] convertCharMatrixToInt(char[][] mat) {
            int n = mat.length;
            int m = mat[0].length;

            int[][] res = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    res[i][j] = mat[i][j] - '0';
                }
            }

            return res;
        }

    }

    public static void main(String args[]) {

    }
}
