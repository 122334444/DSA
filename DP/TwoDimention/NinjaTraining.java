
//A ninja has planned a n-day training schedule. Each day he has to perform one of three activities - 
// running, stealth training, or fighting practice. The same activity cannot be done on two consecutive 
// days and the ninja earns a specific number of merit points, based on the activity and the given day.

//Given a n x 3-sized matrix, where matrix[i][0], matrix[i][1], and matrix[i][2], represent the merit points
//  associated with running, stealth and fighting practice, on the (i+1)th day respectively. Return the maximum
//  possible merit points that the ninja can earn.

class Solution {
    public int NinjaTraining(int[][] matrix) {
        int n=matrix.length;
        int dp[][]=new int[n][4];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(n-1,3,matrix,dp);
    }

    private int solve(int idx,int prev,int mat[][],int dp[][]){
        if(idx==0){
            int max=0;
            for(int i=0;i<3;i++){
                if(i!=prev){
                    max=Math.max(max,mat[0][i]);
                }
            }
            return max;
        }

        if(dp[idx][prev]!=-1)return dp[idx][prev];

        int max=0;
        for(int i=0;i<3;i++){
            if(i!=prev){
                int pt=mat[idx][i]+solve(idx-1,i,mat,dp);
                max=Math.max(max,pt);
            }
        }
        return dp[idx][prev]=max;
    }
}