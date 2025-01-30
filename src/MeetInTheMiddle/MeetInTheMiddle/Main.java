package MeetInTheMiddle.MeetInTheMiddle;

import java.util.Scanner;
import java.util.*;
public class Main {

    public static List<Long> subsetSum(int []nums, int left, int right){
        List<Long> res = new ArrayList<>();
        int size=right-left+1;
        int totalMask= 1<<size;

        for(int mask=0;mask<totalMask;mask++){
            long sum=0;
            for(int i=0;i<size;i++){
                if((mask& (1<<i))!=0) sum+=nums[i+left];
            }
            res.add(sum);
        }
        return res;
    }
    public static int lowerBound(List<Long> list, long el){
        int left=0;
        int right=list.size()-1;

        while(left<=right){
            int mid=left+(right-left)/2;
            if(list.get(mid)>=el) right=mid-1;
            else left=mid+1;
        }
        return left;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        List<Long> left= subsetSum(arr, 0, n/2-1);
        List<Long> right = subsetSum(arr, n/2, n-1);

        Collections.sort(right);

        long count=0;
        for(long el : left){
            long remain=x-el;
            int firstOcc=lowerBound(right, remain);
            if(firstOcc==right.size() || right.get(firstOcc)!=remain) continue;
            int lastOcc=lowerBound(right, remain+1)-1;
            count=count+lastOcc-firstOcc+1;

        }
        System.out.println(count);
    }
}
