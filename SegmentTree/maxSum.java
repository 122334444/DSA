package SegmentTree;

public class maxSum {

    public static class Pair {
        int sum; // maximum pair sum
        int max; // maximum element

        public Pair(int sum, int max) {
            this.sum = sum;
            this.max = max;
        }
    }

    static Pair tree[];
    static int arr[];

    // Build Segment Tree
    public static void build(int node, int st, int end) {

        // Leaf node
        if (st == end) {
            tree[node] = new Pair(arr[st], arr[st]);
            return;
        }

        int mid = (st + end) / 2;

        build(node * 2, st, mid);
        build(node * 2 + 1, mid + 1, end);

        tree[node] = calc(tree[node * 2], tree[node * 2 + 1]);
    }

    // Merge two nodes
    static Pair calc(Pair left, Pair right) {

        Pair ans = new Pair(0, 0);

        // Maximum pair sum
        ans.sum = Math.max(
                Math.max(left.sum, right.sum),
                left.max + right.max);

        // Maximum single element
        ans.max = Math.max(left.max, right.max);

        return ans;
    }

    // Update value at index
    static void update(int node, int st, int end, int idx, int val) {

        if (st == end) {
            arr[idx] = val;
            tree[node] = new Pair(val, val);
            return;
        }

        int mid = (st + end) / 2;

        if (idx <= mid) {
            update(node * 2, st, mid, idx, val);
        } else {
            update(node * 2 + 1, mid + 1, end, idx, val);
        }

        tree[node] = calc(tree[node * 2], tree[node * 2 + 1]);
    }

    // Query in range [l, r]
    public static Pair query(int node, int st, int end, int l, int r) {

        // Completely outside
        if (r < st || end < l) {
            return new Pair(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }

        // Completely inside
        if (l <= st && end <= r) {
            return tree[node];
        }

        int mid = (st + end) / 2;

        Pair left = query(node * 2, st, mid, l, r);
        Pair right = query(node * 2 + 1, mid + 1, end, l, r);

        // Handle invalid sides
        if (left.max == Integer.MIN_VALUE)
            return right;

        if (right.max == Integer.MIN_VALUE)
            return left;

        return calc(left, right);
    }

    public static void main(String args[]) {

        arr = new int[] { 6, 10, 9, 5, 4, 12, 1, 8 };

        int n = arr.length;

        tree = new Pair[4 * n];

        // Build tree
        build(1, 0, n - 1);

        // Query example
        Pair ans = query(1, 0, n - 1, 0, 4);

        System.out.println("Maximum Pair Sum = " + ans.sum);

        // Update example
        update(1, 0, n - 1, 2, 20);

        Pair ans2 = query(1, 0, n - 1, 0, 4);

        System.out.println("After Update Maximum Pair Sum = " + ans2.sum);
    }
}