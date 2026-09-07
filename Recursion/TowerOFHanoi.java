package Recursion;

public class TowerOFHanoi {

    public static void towerofHanoi(int n, int t1, int t2, int t3) {
        if (n == 0) {
            return;
        }

        towerofHanoi(n - 1, t1, t3, t2);// ill move disk from t1 to t3 using t2
        System.out.println(n + "[" + t1 + " -> " + t2 + "]");
        towerofHanoi(n - 1, t3, t2, t1);
    }

    public static void main(String args[]) {
        int n = 3;
        int t1 = 1;
        int t2 = 2;
        int t3 = 3;
        towerofHanoi(n, t1, t2, t3);
    }
}
