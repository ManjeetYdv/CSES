package SortingAndSearching.Towers;

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
    public static int lowerBound(List<Integer> towers, int curr){
        int low=0;
        int high=towers.size()-1;
        while(low<=high){
            int middle=low+(high-low)/2;
            if(towers.get(middle)>curr) high=middle-1;
            else low=middle+1;
        }
        return low;
    }
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int n=in.nextInt();
            List<Integer> towers= new ArrayList<>();
            while(n-- > 0){
                int h =in.nextInt();
                int pos=lowerBound(towers, h);
                if(pos==towers.size()) towers.add(h);
                else towers.set(pos, h);
            }
            out.println(towers.size());
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
