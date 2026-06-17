package DP.dpOnStrings;

public class longestCommonSubsequence {

    // public int longestCommonSubsequence(String x, String y) {
    // int n=x.length();
    // int m=y.length();
    // int dp[][]=new int[n][m];
    // for(int i=0;i<n;i++){
    // Arrays.fill(dp[i],-1);
    // }
    // return solve(x,y,n-1,m-1,dp);
    // }

    // private int solve(String x,String y,int i,int j,int dp[][]){
    // if(i<0 || j<0){//agar0 kare to wo 0 idx per hi stop hojayge
    // return 0;
    // }//koi ek bhi str empty hai to max len 0 hi hoga

    // if(dp[i][j]!=-1)return dp[i][j];

    // //Match
    // if(x.charAt(i)==y.charAt(j)){
    // return dp[i][j]=1+solve(x,y,i-1,j-1,dp);
    // }else{//Not Match
    // return dp[i][j]=Math.max(solve(x,y,i-1,j,dp),solve(x,y,i,j-1,dp));
    // }
    // }

    public static int longestCommonSubsequence(String x, String y) {
        int n = x.length();
        int m = y.length();

        int dp[][] = new int[n + 1][m + 1];

        // initialisation
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];

    }

    public static void main(String args[]) {
        String x = "abcde";
        String y = "ace";

        System.out.println(longestCommonSubsequence(x, y));
    }

}
