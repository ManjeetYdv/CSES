package SortingAndSearching.FactoryMachines;

import java.util.*;
import java.io.*;

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
    public static boolean bs(int []times, int products, long maxTime){
        long made=0;
        for(int time: times){
            made+=maxTime/time;
            if(made>=products){ return true;}
        }
        return false;
    }
    public  static long minTime(int []times, int products, int fastest){
        long low=0;
        long high=(long)fastest*products;
        while(low<=high){
            long mid=low+(high-low)/2;
            if(bs(times, products, mid)) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int n=in.nextInt();
            int prod= in.nextInt();
            int[] times= new int[n];
            int fastest=(int)1e9;
            int idx=0;
            while(n-- > 0){
               int time=in.nextInt();
               fastest=Math.min(fastest, time);
               times[idx++]=time;
            }
            out.println(minTime(times, prod, fastest));
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}