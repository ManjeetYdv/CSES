package SortingAndSearching.TaskAndDeadlines;

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
            List<int[]>tasks= new ArrayList<>();
            while(n-- > 0){
                int time=in.nextInt();
                int deadLine=in.nextInt();
                tasks.add(new int[]{time,deadLine});
            }
            Collections.sort(tasks, (a,b)->a[0]==b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
            long curr=0;
            long reward=0;
            for(int []task: tasks){
                curr+=task[0];
                reward+=(task[1]-curr);

            }
            out.println(reward);
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
