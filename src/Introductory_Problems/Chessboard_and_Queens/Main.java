package Introductory_Problems.Chessboard_and_Queens;
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
    public static boolean valid(int row, int col, int[]place){
        for(int i=0;i<row;i++){
            if(place[i]==col || Math.abs(row-i)==Math.abs(col-place[i])) return false;
        }
        return true;
    }
    public static int helper(int row, char[][]board, int []place){
        if(row==8) return 1;
        int ways=0;
        for(int i=0;i<8;i++){
            if(board[row][i]!='*' && valid(row, i, place)){
                place[row]=i;
                ways+=helper(row+1, board, place);
            }
        }
        return ways;
    }
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            char[][] board = new char[8][8];
            for(int i=0;i<8;i++){
                board[i]=in.nextLine().toCharArray();
            }

            int[]place = new int[8];
            out.println(helper(0, board, place));
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}