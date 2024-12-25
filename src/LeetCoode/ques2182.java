package LeetCoode;

import java.util.PriorityQueue;

public class ques2182 {
    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int []f = new int[26];
        for(char ch : s.toCharArray()) f[ch-'a']++;

        for(int i=0;i<26 ;i++){
            if(f[i]!=0) pq.add(i);
        }
        StringBuilder sb= new StringBuilder();
        while(!pq.isEmpty()){
            int max=pq.poll();
            if(f[max]>repeatLimit){
                for(int j=0;j<repeatLimit;j++) sb.append((char)(f[max]+'a'));
                if(pq.isEmpty()) break;
                int secondMax=pq.poll();
                sb.append((char)(secondMax+'a'));

                f[max]-=repeatLimit;
                f[secondMax]-=1;
                if(f[secondMax]>0) pq.add(secondMax);
                if(f[max]>0) pq.add(max);
            }
            else{
                for(int i=0;i<f[max];i++) sb.append((char)(max+'a'));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {

    }
}
