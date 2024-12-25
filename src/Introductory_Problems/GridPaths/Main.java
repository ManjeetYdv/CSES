package Introductory_Problems.GridPaths;

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
    public static boolean valid(int row, int col, boolean[][]vis){
        if(row<0 || col<0 || row>=7 || col>=7 || vis[row][col]) return false;
        else return true;

    }
    public static boolean hitAWall(int row, int col, boolean[][]vis){
        boolean rowWall= (row==0 || row==6) && (col>=1 && col<=5 && !vis[row][col-1] && !vis[row][col+1]);
        boolean colWall= (col==0 || col==6) && (row>=1 && row<=5 && !vis[row+1][col] && !vis[row-1][col]);
        if( rowWall || colWall) return true;

        if(row>=1 && row<=5 && col>=1 && col <=5){
            boolean rightLeftWall= vis[row][col+1] && vis[row][col-1] && !vis[row+1][col] && !vis[row-1][col];
            boolean upDownWall = vis[row+1][col] && vis[row-1][col] && !vis[row][col-1] && !vis[row][col+1];
            return rightLeftWall || upDownWall;
        }
        return false;
    }
    public static int ways(int index, int row, int col, String path, boolean[][]vis){
        if(row<0 || col<0 || row>=7 || col>=7 || vis[row][col]) return 0;
        if(row==6 && col==0 && index==path.length()) return 1;
        else if(row==6 && col==0) return 0;

        if(index==path.length()) return 0 ;
        if(hitAWall(row, col, vis)) return 0;

        int ways=0;
        char dir=path.charAt(index);

        vis[row][col]=true;
        if(dir=='?'){
            ways+=ways(index+1, row+1, col, path, vis );
            ways+=ways(index+1, row, col+1, path, vis );
            ways+=ways(index+1, row-1, col, path, vis );
            ways+=ways(index+1, row, col-1, path, vis );
        }
        else if(dir=='U') ways+=ways(index+1, row-1, col, path, vis );
        else if(dir=='D')  ways+=ways(index+1, row+1, col, path, vis );
        else if(dir=='L')  ways+=ways(index+1, row, col-1, path, vis );
        else if(dir=='R')  ways+=ways(index+1, row, col+1, path, vis );

        vis[row][col]=false;
        return ways;
    }
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            String s= in.next();
            boolean [][]vis= new boolean[7][7];
            int count= ways(0, 0,0, s, vis);
            out.println(count);
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}