package LeetCoode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class que2981 {
    public static int maximumLength(String s) {
        int l=0;
        int r=s.length()-2;
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(found(s, mid)){l=mid+1; ans=mid;}
            else r=mid-1;
        }
        return ans==-1?-1:ans+1;
    }
    public static boolean found(String s, int window){
        int[]f=new int[26];
        int count=0;;
        for(int i=0;i<s.length();i++){
            if(i==0 || s.charAt(i)==s.charAt(i-1)) count++;
            else count=1;

            if(count>window) f[s.charAt(i)-'a']++;
            if(f[s.charAt(i)-'a']==3) return true;
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
