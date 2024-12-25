package Introductory_Problems.CoinPiles;

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
    public static boolean helper(int a, int b , int[][]dp){
        if(a==0 && b==0) return true;
        if(a==0 || b==0 || (a==1 && b==1)) return false;
        if(dp[a][b]!=-1) return dp[a][b]==1;

        boolean ans= helper(a-1, b-2, dp) || helper(a-2, b-1, dp);
        dp[a][b]= ans?1:0;
        return ans;
    }
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int testCases=in.nextInt();
           // int[][]dp=new int[(int)1e4][(int)1e4];
          //  for(int []a : dp) Arrays.fill(a, -1);
            while(testCases-- > 0){
               int a=in.nextInt();
               int b=in.nextInt();
                // Check mathematical conditions
                if((a+b)%3==0 && a<=2*b && b<=2*a){
                    out.println("YES");
                } else {
                    out.println("NO");
                }

            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}