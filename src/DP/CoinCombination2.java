package DP;

import java.util.Arrays;
import java.util.Scanner;

public class CoinCombination2 {
    static int mod = 1000000007;
    public static int helper(int idx, int []coins, int[][]dp, int x){
        if(x==0) return 1;
        if(idx==coins.length) return 0;
        if(dp[idx][x]!=-1) return dp[idx][x];

        int skip=helper(idx+1, coins, dp, x);
        int pick=0;
        if(x>=coins[idx]) pick = helper(idx, coins, dp, x-coins[idx]);
        return dp[idx][x]=(skip+pick)%mod;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x =sc.nextInt();
        int[][] dp = new int[n][x+1];
        for(int []r : dp) Arrays.fill(r,-1);
        int []coins = new int[n];
        for(int i=0;i<n;i++){
            coins[i]=sc.nextInt();
        }
        System.out.println(helper(0, coins, dp, x));
    }
}
