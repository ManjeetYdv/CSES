//package DP;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class CoinCombination2 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int x =sc.nextInt();
//        int[][] dp = new int[x+1][n];
//
//        int []coins = new int[n];
//        for(int i=0;i<n;i++){
//            coins[i]=sc.nextInt();
//        }
//        Arrays.sort(coins);
//
//        for(int i=0;i<n;i++) dp[0][i]=1;
//
//        for(int i=1;i<=x;i++){
//            for(int j=0;j<n;j++){
//                if(i>=coins[j]){
//                    dp[i][j]=dp[i-coins[j]][j];
//                }
//                if(j>0)dp[i][j]=(dp[i][j]+dp[i][j-1])%1000000007;
//            }
//        }
//        System.out.println(dp[x][n-1]);
//    }
//}
