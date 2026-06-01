package Recursion;

public class powerXn {

    public static double pow(int x, int n) {
        double ans = 1.0;
        long nn = n;
        while (nn > 0) {
            if (nn % 2 == 0) {
                ans = ans * x;
                nn--;
            } else {
                x = x * x;// ek ko multiply karke nn ko even bna idya
                nn = nn / 2;
            }
        }
        if (n < 0)
            ans = (double) (1.0) / (double) (ans);
        return ans;
    }

    public static void main(String argsp[]) {
        int x = 5;

        int n = 12;
        System.out.println(pow(x, n));
    }
}
