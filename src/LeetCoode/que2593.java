package LeetCoode;

import java.util.PriorityQueue;

public class que2593 {
    public long findScore(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->nums[a]-nums[b]);
        for(int i=0;i<nums.length;i++){
            pq.add(i);
        }
        long res=0;
        while(!pq.isEmpty()){
            int min=pq.poll();
            if(nums[min]<0) continue;
            res+=nums[min];
            nums[min]*=-1;
            if(min-1>=0 && nums[min-1]>0) nums[min-1]*=-1;
            if(min+1<nums.length && nums[min+1]<0) nums[min+1]*=-1;
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
