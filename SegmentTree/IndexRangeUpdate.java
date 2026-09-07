package SegmentTree;

public class IndexRangeUpdate {
    static int[] tree;
    static int[] lazy;
    static int[] arr;

    // Build Segment Tree
    static void build(int node, int start, int end) {

        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);

        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    // Range Update with Lazy Propagation
    static void update(int node, int start, int end,
            int left, int right, int val) {

        // First resolve pending lazy updates
        if (lazy[node] != 0) {

            tree[node] += (end - start + 1) * lazy[node];

            if (start != end) {
                lazy[2 * node] += lazy[node];
                lazy[2 * node + 1] += lazy[node];
            }

            lazy[node] = 0;
        }

        // No overlap
        if (start > right || end < left) {
            return;
        }

        // Complete overlap
        if (start >= left && end <= right) {

            tree[node] += (end - start + 1) * val;

            if (start != end) {
                lazy[2 * node] += val;
                lazy[2 * node + 1] += val;
            }

            return;
        }

        // Partial overlap
        int mid = (start + end) / 2;

        update(2 * node, start, mid, left, right, val);
        update(2 * node + 1, mid + 1, end, left, right, val);

        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    // Range Query
    static int query(int node, int start, int end,
            int left, int right) {

        // Resolve lazy updates
        if (lazy[node] != 0) {

            tree[node] += (end - start + 1) * lazy[node];

            if (start != end) {
                lazy[2 * node] += lazy[node];
                lazy[2 * node + 1] += lazy[node];
            }

            lazy[node] = 0;
        }

        // No overlap
        if (start > right || end < left) {
            return 0;
        }

        // Complete overlap
        if (start >= left && end <= right) {
            return tree[node];
        }

        // Partial overlap
        int mid = (start + end) / 2;

        int q1 = query(2 * node, start, mid, left, right);
        int q2 = query(2 * node + 1, mid + 1, end, left, right);

        return q1 + q2;
    }

    public static void main(String[] args) {

        arr = new int[] { 1, 2, 3, 4, 5 };

        int n = arr.length;

        tree = new int[4 * n];
        lazy = new int[4 * n];

        build(1, 0, n - 1);

        // Sum from 1 to 3
        System.out.println(query(1, 0, n - 1, 1, 3));

        // Add 10 in range [1,3]
        update(1, 0, n - 1, 1, 3, 10);

        // Query again
        System.out.println(query(1, 0, n - 1, 1, 3));
    }
}
