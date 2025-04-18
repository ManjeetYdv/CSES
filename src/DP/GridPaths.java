package DP;

import java.util.Arrays;
import java.util.Scanner;

public class GridPaths {
    static int mod=(int)1e9+ 7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = sc.next().toCharArray();
        }
//        if(grid[0][0]=='*' || grid[n-1][n-1]=='*') {
//            System.out.println(0);
//            return;
//        }
        int[][]dp = new int[n][n];
        dp[0][0]=1;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i==0 && j==0) continue;
                if(grid[i][j]=='.') {
                    int up= 0;
                    int left=0;
                    if(i-1>=0 && grid[i-1][j]=='.') {
                        up= dp[i-1][j];
                    }
                    if(j-1>=0 && grid[i][j-1]=='.') {
                        left= dp[i][j-1];
                    }
                    dp[i][j]=(up+left)%mod;
                }
            }
        }
        System.out.println(dp[n-1][n-1]);

    }
}
