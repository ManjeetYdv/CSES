package LeetCoode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ques2762 {
    public long continuousSubarrays(int[] nums) {
        int i=0;
        int j=0;
        long res=0;
        Deque<Integer> minQueue=new ArrayDeque<>();
        Deque<Integer> maxQueue=new ArrayDeque<>();

        while(j<nums.length){
            while(minQueue.size()>0 && Math.abs(nums[j]-nums[minQueue.peek()])>2){
                if(minQueue.peek()==i) minQueue.removeFirst();
                if(maxQueue.peek()==i) maxQueue.removeFirst();
                i++;
            }
            while(maxQueue.size()>0 && Math.abs(nums[j]-nums[maxQueue.peek()])>2){
                if(maxQueue.peek()==i) maxQueue.removeFirst();
                if(minQueue.peek()==i) minQueue.removeFirst();
                i++;
            }

            res+=j-i+1;
            while(minQueue.size()>0 && nums[minQueue.getLast()]>=nums[j]) minQueue.removeLast();
            while(maxQueue.size()>0 && nums[maxQueue.getLast()]<=nums[j]) maxQueue.removeLast();
            minQueue.add(j);
            maxQueue.add(j);
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
