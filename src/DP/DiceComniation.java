package DP;

import java.util.Arrays;
import java.util.Scanner;

public class DiceComniation {
    static int[]dp;
    public static int helper(int x){
        if(x==0)return 1;
        if(dp[x]!=-1) return dp[x];

        int ways=0;
        for(int i=1;i<=6;i++){
            if(x>=i){
                ways=(ways+helper(x-i))%1000000007;
            }
        }
        return dp[x]= ways;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int []dp = new int[x+1];
        dp[0]=1;
        for(int i=1;i<=x;i++){
            for(int j=1;j<=6;j++){
                if(i>=j){
                    dp[i]=(dp[i]+dp[i-j])%1000000007;
                }
            }
        }
        System.out.println(dp[x]);
    }
}
