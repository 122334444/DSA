package Greedy;

import java.util.*;

public class NmetingsInRoom {

    static class DS {
        int st;
        int end;
        int pos;

        public DS(int st, int end, int pos) {
            this.st = st;
            this.end = end;
            this.pos = pos;
        }
    }

    public static ArrayList<Integer> meetings(int st[], int end[]) {
        int n = st.length;

        DS arr[] = new DS[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new DS(st[i], end[i], i + 1);
        }

        Arrays.sort(arr, (a, b) -> a.end - b.end);

        int count = 1;
        int freeTime = arr[0].end;
        ArrayList<Integer> ls = new ArrayList<>();
        ls.add(arr[0].pos);

        for (int i = 1; i < n; i++) {
            if (arr[i].st > freeTime) {
                count++;
                ls.add(arr[i].pos);
                freeTime = arr[i].end;
            }
        }
        return ls;
    }

    public static void main(String args[]) {
        int st[] = { 0, 3, 1, 5, 5, 8 };
        int end[] = { 5, 4, 2, 9, 7, 9 };

        ArrayList<Integer> ls = meetings(st, end);

        for (int x : ls) {
            System.out.print(x + " ");
        }
    }
}
