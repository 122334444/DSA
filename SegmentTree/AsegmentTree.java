package SegmentTree;

public class AsegmentTree {

    static int tree[];
    static int arr[] = { 1, 3, 2, 7, 9, 11 };

    // build segment tree
    static void build(int node, int start, int end) {

        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);

        tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
    }

    // range maximum query -> will return the maximum inna given range l,r
    static int query(int node, int start, int end, int l, int r) {

        // no overlap
        if (r < start || end < l) {
            return Integer.MIN_VALUE;
        }

        // complete overlap
        if (l <= start && end <= r) {
            return tree[node];
        }

        // partial overlap
        int mid = (start + end) / 2;

        int left = query(2 * node, start, mid, l, r);
        int right = query(2 * node + 1, mid + 1, end, l, r);

        return Math.max(left, right);
    }

    public static void main(String[] args) {

        int n = arr.length;

        tree = new int[4 * n];

        build(1, 0, n - 1);

        System.out.println(query(1, 0, n - 1, 1, 4)); // 9
        System.out.println(query(1, 0, n - 1, 2, 5)); // 11
    }
}