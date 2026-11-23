package DP.TwoDimention;

public class equalSumPartition {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int x: nums){
            sum+=x;
        }
        if(sum%2==1)return false;

        int k=sum/2;
        int n=nums.length;
        Boolean dp[][]=new Boolean[n][k+1];
         return solve(n-1,nums,k,dp);
    }

    private boolean solve(int idx,int nums[],int k,Boolean dp[][]){
        //base case
        if(idx==0){
            if(nums[idx]==k){
                return true;
            }else{
                return false;
            }
        }

        if(dp[idx][k]!=null)return dp[idx][k];

        boolean skip=solve(idx-1,nums,k,dp);

        boolean take=false;
        if(k>=nums[idx]){
            take=solve(idx-1,nums,k-nums[idx],dp);
        }

        return dp[idx][k]=(take||skip);
    }   
}
