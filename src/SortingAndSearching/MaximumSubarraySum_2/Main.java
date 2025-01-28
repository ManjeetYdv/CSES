package SortingAndSearching.MaximumSubarraySum_2;
import java.util.*;

public class Main {
    public static long maxSubarraySum(int[] nums, int a, int b){
      Deque<Integer> deque = new LinkedList<>();
      long []psum= new long[nums.length];
      psum[0] = nums[0];
      for(int i=1;i<nums.length;i++){
          psum[i] = psum[i-1]+nums[i];
      }
      long res=psum[a-1];
      deque.add(-1);
      for(int i=a;i<nums.length;i++){
          if(i-b-1>=0){
              if(deque.peekFirst()==i-b-1) deque.removeFirst();
          }
          int add=i-a;
          while(!deque.isEmpty()){
              if(deque.peekLast()==-1 && psum[add]<=0) deque.removeLast();
              else if(psum[deque.peekLast()]>=psum[add]) deque.removeLast();
          }
          deque.addLast(add);

          long prev=deque.peekFirst()==-1?0 : psum[deque.peekFirst()];
          res=Math.max(res,psum[i]-prev);
      }
      return res;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int []arr = new int[n];
        int a= sc.nextInt();
        int b= sc.nextInt();

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(maxSubarraySum(arr, a, b));

    }
}
