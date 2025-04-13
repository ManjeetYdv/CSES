package DP.MinimizingCoins;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x =sc.nextInt();
        int []coins = new int[n];
        int[] dp = new int[x+1];
        dp[0]=0;
        for(int i=0;i<n;i++){
            coins[i]=sc.nextInt();
        }
        for(int i=1;i<=x;i++){
            dp[i]=Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                if(i>=coins[j]){
                    dp[i]=Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }
        System.out.println(dp[x]);
    }
}
