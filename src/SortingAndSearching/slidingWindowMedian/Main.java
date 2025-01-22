//package SortingAndSearching.slidingWindowMedian;

import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }
    public static void balance(TreeMap<Integer, Integer>left, TreeMap<Integer, Integer> right, int[]size){
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
        }
    }
    public static void insert(int val, TreeMap<Integer, Integer> left, TreeMap<Integer, Integer> right, int[]size){
        if (left.size()==0 || left.lastKey() >= val) {
            left.put(val, left.getOrDefault(val, 0)+1);
            size[0]++;
        }
        else {
            right.put(val, right.getOrDefault(val, 0)+1);
            size[1]++;
        }
        balance(left, right, size);
    }
    public static void remove(int val, TreeMap<Integer, Integer> left, TreeMap<Integer, Integer> right, int[]size){
        if(left.containsKey(val)){
            int freq=left.get(val);
            if(freq==1) left.remove(val);
            else left.put(val, freq-1);
            size[0]--;
        }
        else{
            int freq=right.get(val);
            if(freq==1) right.remove(val);
            else right.put(val, freq-1);
            size[1]--;
        }
        balance(left, right, size);
    }
    public static int getMedian(TreeMap<Integer, Integer> left){
        return left.lastKey();
    }
    public static void medianSlidingWindow(int[] nums, int k, FastWriter out) throws Exception{
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();
        int []size = new int[2];

        for(int i=0;i<k-1;i++){
            insert(nums[i], left, right, size);
        }
        int []res= new int[nums.length-k+1];
        for(int i=k-1;i<nums.length;i++){
            insert(nums[i], left, right, size);
            out.print(getMedian(left)+" ");
            int removeEl = nums[i - k + 1];
            remove(removeEl, left, right, size);
        }

    }

    public static void main(String[] args) {

        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int n=in.nextInt();
            int k=in.nextInt();
            int[]nums=new int[n];
            for(int i=0;i<n;i++){
                nums[i]=in.nextInt();
            }
            medianSlidingWindow(nums, k , out);
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}