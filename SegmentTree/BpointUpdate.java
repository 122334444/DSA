package SegmentTree;

public class BpointUpdate {

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

    public static void update(int node, int st, int end, int pos, int val) {

        if (st == end) {
            arr[st] = val;
            tree[node] = val;
            return; // missing
        }

        int mid = (st + end) / 2;

        if (st <= pos && pos <= mid) {
            update(node * 2, st, mid, pos, val);
        } else {
            update(node * 2 + 1, mid + 1, end, pos, val);
        }

        tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
    }

    public static void main(String args[]) {

        tree = new int[4 * arr.length];

        build(1, 0, arr.length - 1);

        update(1, 0, arr.length - 1, 4, 15);

        for (int x : arr) {
            System.out.println(x);
        }
    }
}
