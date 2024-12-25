package Introductory_Problems.NumberSpiral;

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
            int testCases=in.nextInt();

            while(testCases-- > 0){
               int x=in.nextInt()-1;
               int y=in.nextInt()-1;
               long val=1;
               if(x>y) {
                   //row bigger
                   if(x%2==0) val=(long)x*x +1;
                   else val=((long)x+1)*(x+1);

                   if(x%2==0) out.println(val+y);
                   else out.println(val-y);
               }
               else{
                 //col bigger
                   if(y%2==0) val=((long)y+1)*(y+1);
                   else val=(long)y*y+1;

                   if(y%2==0) out.println(val-x);
                   else  out.println(val+x);
               }
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}