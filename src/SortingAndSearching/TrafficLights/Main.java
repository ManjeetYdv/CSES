package SortingAndSearching.TrafficLights;


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
            //out.println("here");
            int n=in.nextInt();
            int m=in.nextInt();
         //   out.println("here1");
            TreeSet<Integer> set=  new TreeSet<>();
            set.add(0);
            set.add(n);
            TreeMap<Integer, Integer> map = new TreeMap<>();
         //   out.println("here2");
            StringBuilder sb = new StringBuilder();
            while(m-- > 0){
                int light=in.nextInt();
                int lower=set.floor(light);
                int higher=set.ceiling(light);
                int dist=higher-lower;
                if(map.containsKey(dist)) map.put(dist, map.get(dist)-1);
                if(map.containsKey(dist) && map.get(dist)==0) map.remove(dist);
                set.add(light);
                int leftDist=light-lower;
                int rightDist=higher-light;
                map.put(leftDist, map.getOrDefault(leftDist, 0)+1);
                map.put(rightDist, map.getOrDefault(rightDist, 0)+1);

                sb.append(map.lastKey()+" ");
            }
            out.println(sb.toString());
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}