package SortingAndSearching.Playlist;

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
            HashMap<Integer, Integer> map = new HashMap<>();
            int i=0;
            int j=0;
            int max=0;
            while(n-- > 0){
               int num = in.nextInt();
               if(map.containsKey(num)) i = Math.max(i,map.get(num)+1);
               map.put(num, j);
              //
                // out.println(num+" "+(j-i+1)+ " ................j is : "+j+" ,,,,,,,i is:" +i);
               max=Math.max(max, j-i+1);
               j++;
            }
            out.println(max);
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}