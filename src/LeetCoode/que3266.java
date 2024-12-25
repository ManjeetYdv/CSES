//package LeetCoode;
//import java.util.*;
//
//public class que3266 {
//    class CustomComparator implements Comparator<Integer> {
//        private int[]res;
//        public CustomComparator(int[] res) {  this.res=res;}
//        public int compare(Integer a, Integer b){
//            if(res[a]==res[b]){
//                return a-b;
//            }
//            else if(res[a]>res[b]) return 1;
//            else return -1;
//        }
//    }
//    public int[] getFinalState(int[] nums, int k, int multiplier) {
//        long []res= new long[nums.length];
//        PriorityQueue<Integer>pq = new PriorityQueue<>(new CustomComparator(res));
//        for(int i=0;i<nums.length ;i++){
//            res[i]=nums[i];
//            pq.add(i);
//        }
//
//        while(k-->0){
//            int minId=pq.poll();
//            res[minId]*=multiplier;
//            pq.add(minId);
//        }
//        int mod=(int)1e9 +7;
//        for(int i=0;i<res.length ;i++) nums[i]=(int)(res[i]%mod);
//        return nums;
//    }
//    public static void main(String[] args) {}
//}
