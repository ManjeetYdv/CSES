package DP;
import java.util.*;

public class RectangleCutting {
    static int[][]dp;
    public static int helper(int h, int w) {
        if(h==w) return 0;
        if(dp[h][w]!=-1) return dp[h][w];
        int min=Integer.MAX_VALUE;
        for(int i=1;i<h;i++){
            int  op =1+ helper(i, w)+ helper(h-i, w);
            min=Math.min(min,op);
        }
        for(int i=1;i<w;i++){
            int op= 1+helper(h, i) + helper(h, w-i);
            min=Math.min(min,op);
        }
        return dp[h][w]= min;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        dp = new int[n+1][m+1];

        for(int []row : dp){
            Arrays.fill(row, -1);
        }

        System.out.println(helper(n, m));

    }
}
