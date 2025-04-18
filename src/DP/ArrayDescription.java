package DP;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDescription {
    static int [][]dp;
    static int mod = (int)1e9+7;

    public static int helper(int idx, int prev, int []arr, int n, int m){
        if(idx==n) return 1;
        if(dp[idx][prev]!=-1) return dp[idx][prev];
        if(arr[idx]!=0){
            if(Math.abs(arr[idx]-prev)>1) return dp[idx][prev]= 0;
            else return dp[idx][prev]= helper(idx+1, arr[idx], arr, n, m);
        }
        else{
            int ways= helper(idx+1, prev, arr, n, m);
            if(prev-1>0) ways =(ways + helper(idx+1, prev-1, arr, n, m))%mod;
            if(prev+1<=m) ways =(ways+ helper(idx+1, prev+1, arr, n, m))%mod;
            return dp[idx][prev]=ways;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int []arr = new int[n];
        dp = new int[n][m+1];
        for(int []r: dp) Arrays.fill(r, -1);
        for(int i=0; i<n;i++){
            arr[i] = sc.nextInt();
        }
        if(arr[0]!=0){
            System.out.println(helper(1, arr[0], arr, n, m));
        }
        else{
            int ways=0;
            for(int i=1; i<=m; i++){
                ways = (ways + helper(1, i, arr, n, m))%mod;
            }
            System.out.println(ways);
        }
    }
}
