package DP;

import java.util.Arrays;
import java.util.Scanner;

public class CoinCombination_1 {
    static final int mod = (int)1e9+7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[]coins = new int[n];
        int[]dp = new int[x+1];
        dp[0]=1;

        for(int i=1;i<=x;i++){
            for(int c : coins){
                if(i>=c){
                    dp[i]=(dp[i]+dp[i-c])%mod;
                }
            }
        }
        System.out.println(dp[x]);
    }
}
