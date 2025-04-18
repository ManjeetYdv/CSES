package DP;

import java.util.Arrays;
import java.util.Scanner;

public class RemovingDigit {
    public static int helper(int x, int[]dp){
        if(x==0) return 0;
        if(dp[x]!=-1) return dp[x];
        int d=(int)Math.log10(x)+1;

        int div=1;
        int num=x;
        int minSteps=Integer.MAX_VALUE;
        for(int i=0;i<d;i++){
            num/=div;
            if(num%10!=0) minSteps=Math.min(minSteps, helper(x-num%10, dp)+1);
            div*=10;
        }
        return dp[x]= minSteps;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[]dp = new int[x+1];
        Arrays.fill(dp,-1);
        System.out.println(helper(x, dp));
//        int div=1;
//        int num=x;
//        int d=(int)Math.log10(x)+1;
//        int minSteps=Integer.MAX_VALUE;
//        for(int i=0;i<d;i++){
//            num/=div;
//            System.out.println(x-num %10);
//            div*=10;
//        }
    }
}
