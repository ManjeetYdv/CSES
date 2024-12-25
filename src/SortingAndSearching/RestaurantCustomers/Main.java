package SortingAndSearching.RestaurantCustomers;

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
            List<int[]> sweep = new ArrayList<>();
            while(n-- > 0){
                int a=in.nextInt();
                int b=in.nextInt();
                sweep.add(new int[]{a,1});
                sweep.add(new int[]{b+1, -1});
            }
            Collections.sort(sweep, (a,b)->a[0]==b[0]? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
            long max=0;
            long active=0;
            for(int [] event : sweep){
                active+=event[1];
                if(active>max) max=active;
            }
            out.println(max);
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}