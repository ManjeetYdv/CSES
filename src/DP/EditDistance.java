package DP;

import java.util.Arrays;
import java.util.Scanner;

public class EditDistance {
    static int [][]dp;
    public static int helper(int idx1, int idx2, char[]s, char[]t, int n, int m){
        if(idx1==n && idx2==m) return 0;
        if(idx1==n) return m-idx2;
        if(idx2==m) return n-idx1;
        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];

        if(s[idx1]==t[idx2]){
            return dp[idx1][idx2]= helper(idx1+1, idx2+1, s, t, n, m);
        }
        else{
            int add= helper(idx1, idx2+1, s, t, n, m);
            int remove= helper(idx1+1, idx2, s, t, n, m);
            int replace= helper(idx1+1, idx2+1, s, t, n, m);
            return dp[idx1][idx2]=1+Math.min(add, Math.min(remove, replace));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] s = sc.next().toCharArray();
        char[] t = sc.next().toCharArray();
        dp = new int[s.length][t.length];
        for(int []r : dp) Arrays.fill(r, -1);

        System.out.println(helper(0, 0, s, t, s.length, t.length));
    }
}
