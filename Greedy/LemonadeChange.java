package Greedy;

public class LemonadeChange {
    public static boolean lemonadeChange(int[] bills) {
        int c5 = 0;
        int c10 = 0;
        for (int x : bills) {
            if (x == 5) {
                c5++;
            } else if (x == 10) {
                if (c5 > 0) {
                    c10++;
                    c5--;
                } else {
                    return false;
                }
            } else {
                if (c5 > 0 && c10 > 0) {
                    c5--;
                    c10--;
                } else if (c5 > 2) {
                    c5 -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        int bills[] = { 5, 5, 5, 10, 20 };
        System.out.println(lemonadeChange(bills));
    }
}
