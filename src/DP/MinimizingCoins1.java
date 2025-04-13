package DP;

import java.util.Arrays;
import java.util.Scanner;

public class MinimizingCoins1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[]coins = new int[n];
        for(int i=0;i<n;i++){
            coins[i]=sc.nextInt();
        }
        int []dp = new int[x+1];
        dp[0]=0;

        for(int i=1;i<=x;i++){
            dp[i]=Integer.MAX_VALUE;
            for(int c : coins){
                if(i>=c) dp[i]=Math.min(dp[i], dp[i-c]+1);
            }
        }
        System.out.println(dp[x]);
    }
}
