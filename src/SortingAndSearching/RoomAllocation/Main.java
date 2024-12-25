package SortingAndSearching.RoomAllocation;

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
            int idx=0;
            List<int[]> sweep = new ArrayList<>();
            while(n-- > 0){
                int start=in.nextInt();
                int end=  in.nextInt();
                sweep.add(new int[]{start, 1, idx});
                sweep.add(new int[]{end+1, -1, idx});
                idx++;
            }
            Collections.sort(sweep, (a, b)->a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
            int active=0;
            int rooms=0;
            int max=0;
            Queue<Integer> queue = new LinkedList<>();
            Map<Integer, Integer> currentlyAssigned = new TreeMap<>();
            for(int [] event : sweep){
                if(event[1]==1){
                    active++;
                    max=Math.max(active, max);
                    if(queue.isEmpty()) {
                        currentlyAssigned.put(event[2], active);

                    }
                    else{
                        int availRoom=queue.poll();
                        currentlyAssigned.put(event[2], availRoom);
                    }
                }
                else{
                    active--;
                    int customerIdx=event[2];
                    int nowFreeRoom=currentlyAssigned.get(customerIdx);
                    queue.offer(nowFreeRoom);
                }
            }
            out.println(max);
            for(int customerIndex : currentlyAssigned.keySet()){
                out.print(currentlyAssigned.get(customerIndex)+" ");
            }

            out.close();
        } catch (Exception e) {
            return;
        }
    }
}