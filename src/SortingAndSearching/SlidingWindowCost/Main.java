//package SortingAndSearching.SlidingWindowCost;


import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void balance(TreeMap<Integer, Integer>left, TreeMap<Integer, Integer> right, int[]size, long[]sum){
        int leftEl=size[0];
        int rightEl=size[1];
        if(leftEl==rightEl) return;
        if(leftEl==rightEl+1) return;

        if(leftEl>rightEl){
            Map.Entry<Integer, Integer> maxFromLeft= left.lastEntry();
            int key=maxFromLeft.getKey();
            int val=maxFromLeft.getValue();
            right.put(key, right.getOrDefault(key, 0)+1);
            left.put(key, val-1);
            if(val==1) left.remove(key);

            size[0]--;
            size[1]++;

            sum[0]-=key;
            sum[1]+=key;
        }
        else{
            Map.Entry<Integer, Integer> minFromRight=right.firstEntry();
            int key=minFromRight.getKey();
            int val=minFromRight.getValue();
            left.put(key, left.getOrDefault(key, 0)+1);
            right.put(key, val-1);
            if(val==1) right.remove(key);

            size[0]++;
            size[1]--;

            sum[0]+=key;
            sum[1]-=key;
        }
    }
    public static void insert(int val, TreeMap<Integer, Integer> left, TreeMap<Integer, Integer> right, int[]size, long[]sum){
        if (left.size()==0 || left.lastKey() >= val) {
            left.put(val, left.getOrDefault(val, 0)+1);
            size[0]++;
            sum[0]+=val;
        }
        else {
            right.put(val, right.getOrDefault(val, 0)+1);
            size[1]++;
            sum[1]+=val;
        }
        balance(left, right, size, sum);
    }
    public static void remove(int val, TreeMap<Integer, Integer> left, TreeMap<Integer, Integer> right, int[]size, long[]sum){
        if(left.containsKey(val)){
            int freq=left.get(val);
            if(freq==1) left.remove(val);
            else left.put(val, freq-1);
            size[0]--;
            sum[0]-=val;
        }
        else{
            int freq=right.get(val);
            if(freq==1) right.remove(val);
            else right.put(val, freq-1);
            size[1]--;
            sum[1]-=val;
        }
        balance(left, right, size, sum);
    }
    public static int getMedian(TreeMap<Integer, Integer> left){
        return left.lastKey();
    }
    public static void CostSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();
        int []size = new int[2];
        long[] sum= new long[2];
        for(int i=0;i<k-1;i++){
            insert(nums[i], left, right, size, sum);
        }
        int []res= new int[nums.length-k+1];
        for(int i=k-1;i<nums.length;i++){
            insert(nums[i], left, right, size, sum);
            long mid=getMedian(left);
            long leftSum=sum[0];
            long rightSum=sum[1];
            long changes=mid*size[0]-leftSum + rightSum-mid*size[1];
            System.out.print(changes+" ");

            int removeEl = nums[i - k + 1];
            remove(removeEl, left, right, size, sum);
        }

    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[]nums= new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        CostSlidingWindow(nums, k);
    }
}