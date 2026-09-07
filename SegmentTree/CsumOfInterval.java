package SegmentTree;

public class CsumOfInterval {

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

        tree[node] = tree[2 * node] + tree[2 * node + 1];// stores sum instead of max
    }

    private static void update(int node, int st, int end, int pos, int val) {

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

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public static int sumInterval(int node, int st, int end, int l, int r) {
        if (end < l || st > r) {
            return 0;
        }

        if (st == end) {
            return tree[node];
        } else if (l <= st && end <= r) {
            return tree[node];
        }

        int mid = (st + end) / 2;
        int left = sumInterval(node * 2, st, mid, l, r);
        int right = sumInterval(node * 2 + 1, mid + 1, end, l, r);
        return left + right;

    }

    int sumInterval(int l, int r) {
        return sumInterval(1, 0, arr.length - 1, l, r);
    }

    public static void main(String args[]) {
        tree = new int[arr.length * 4];

        build(1, 0, arr.length - 1);

        System.out.println(sumInterval(1, 0, arr.length - 1, 1, 4));

        update(1, 0, arr.length - 1, 2, 10);

        System.out.println(sumInterval(1, 0, arr.length - 1, 1, 4));

    }
}

// bg