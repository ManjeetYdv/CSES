package SortingAndSearching.Apartments;

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
            int m=in.nextInt();
            int k=in.nextInt();

            int[]need= new int[n];
            int []room=new int[m];
            boolean[]taken=new boolean[m];
            for(int i=0;i<n;i++) need[i]=in.nextInt();
            for(int i=0;i<m;i++) room[i]=in.nextInt();
            Arrays.sort(need);
            Arrays.sort(room);

            int i = 0, j = 0, ans = 0;
            while(i<n && j<m){
                if(room[j]-k <= need[i] && need[i]<=room[j]+k){
                    i++;
                    j++;
                    ans++;
                }
                else if(room[j]+k < need[i]) j++; //room too small
                else if(room[j]-k > need[i]) i++; // room too big
            }
            out.println(ans);
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}