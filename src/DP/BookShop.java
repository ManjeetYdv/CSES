package DP;

import java.util.Arrays;
import java.util.Scanner;

public class BookShop {

//    public static int helper(int idx, int []pages, int[]prices, int x){
//        if(idx==prices.length) return 0;
//        if(dp[idx][x]!=-1) return dp[idx][x];
//        int pick= x>=prices[idx]? pages[idx]+helper(idx+1, pages, prices, x-prices[idx]):0;
//        int skip = helper(idx+1, pages, prices, x);
//        return dp[idx][x]= Math.max(pick, skip);
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int []pages = new int[n];
        int []prices = new int[n];
        for(int i = 0; i < n; i++){
            prices[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            pages[i] = sc.nextInt();
        }
        int[][]dp = new int[n][x+1];

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=x;j++){
                int pick = 0;
                if(i+1<n && j>=prices[i]) {
                    pick +=prices[i]+ dp[i+1][j-prices[i]];
                }
                int skip = i+1<n?dp[i+1][j] :0;
                dp[i][j] = Math.max(pick, skip);
            }
        }
        System.out.println(dp[0][x]);

    }
}
