package DP.DiceCombinations;

import java.util.*;
import java.io.*;

public class Main {
    public static int helper(int x, int[]dp){
        if(x==0)return 1;
        if(dp[x]!=-1) return dp[x];

        long ways=0;
        for(int i=1;i<=6;i++){
            if(x>=i) ways=(ways+helper(x-i, dp))%((int)1e9+7);
        }
        return dp[x]=(int)ways;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(helper(n, dp));
    }
}
