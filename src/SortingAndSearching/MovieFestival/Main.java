package SortingAndSearching.MovieFestival;

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
            int n=in.nextInt();
            List<int[]>timing=new ArrayList<>();
            while(n-- > 0){
                int start=in.nextInt();
                int end=in.nextInt();
                timing.add(new int[]{start, end});
            }
            Collections.sort(timing, (a,b)->a[1]-b[1]);
            int res=0;
            int prev=-1;
            for(int [] movie : timing){
//                out.println(movie[0]+" "+movie[1]);
                if(movie[0]>=prev){
                    res++;
                    prev=movie[1];
                }
            }
            out.println(res);
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
