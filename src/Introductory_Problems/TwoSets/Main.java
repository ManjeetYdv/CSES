package Introductory_Problems.TwoSets;

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
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            long n=in.nextLong();
            long sum=n*(n+1)/2;
            if(sum%2==1) {
                out.print("NO");
            }
            else{
                //find if sum/2 exists?
                out.println("YES");
                long target = sum / 2;
                List<Long> set1 = new ArrayList<>();
                List<Long> set2 = new ArrayList<>();
                long currentSum = 0;

                    // Greedy approach to assign numbers to sets
                for (long i = n; i >= 1; i--) {
                    if (currentSum + i <= target) {
                        set1.add(i);
                        currentSum += i;
                    } else {
                        set2.add(i);
                    }
                }
                out.println(set1.size());
                for(long el : set1) out.print(el+" ");
                out.println("");
                out.println(set2.size());
                for(long el : set2) out.print(el+" ");
            }
            out.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}