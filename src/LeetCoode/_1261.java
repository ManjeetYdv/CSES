package LeetCoode;

import java.util.Scanner;

public class _1261 {
    public static int maxArea(int[] height) {
        int l=0;
        int h=height.length-1;
        int ans=0;
        while(l<h){
            int width=h-l;
            int heigh=Math.min(height[l],height[h]);
            ans=Math.max(ans ,width*heigh);
            if(height[h]>height[l])l++;
            else h--;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str=sc.nextLine();
        String []h = str.split(" ");
        int n=h.length;
        int [] height=new int[n];
        for(int i=0;i<n;i++){
            height[i] = Integer.parseInt(h[i]);
        }
        System.out.println(maxArea(height));
    }
}
