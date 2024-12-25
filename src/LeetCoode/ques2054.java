package LeetCoode;

import java.util.Arrays;

public class ques2054 {
    public int findNext(int currIndex, int [][]events){
        int currEnd=events[currIndex][1];
        int start=currIndex+1;
        int end=events.length-1;

        while(start<=end){
            int mid=start+(end-start)/2;
            if(events[mid][0]>currEnd) end=mid-1;
            else start=mid+1;
        }
        return start;
    }
    public int helper(int index, int[][]events, int pick, int[][]dp){
        if(pick==0) return 0;
        if(index==events.length) return 0;
        if(dp[index][pick]!=-1) return dp[index][pick];
        int use=events[index][2] + helper(findNext(index, events), events, pick-1, dp);
        int skip=helper(index+1, events, pick, dp);
        return dp[index][pick]=Math.max(use, skip);
    }
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a,b)->a[0]-b[0]);
        int[][]dp=new int[events.length][3];
        for(int []a: dp) Arrays.fill(a, -1);
        return helper(0, events, 2, dp);
    }

    public static void main(String[] args) {

    }
}
