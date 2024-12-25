package DP.DiceCombinations;

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
    }
    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void println(Object object) throws IOException {
            bw.append("" + object).append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }

    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();

            int n = in.nextInt();
            int mod = (int) 1e9 + 7;

            long[] dp = new long[n + 1];
            dp[0] = 1; // Base case

            // Tabulation
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= 6; j++) {
                    if (i - j >= 0) {
                        dp[i] = (dp[i] + dp[i - j]) % mod;
                    }
                }
            }

            out.println(dp[n]);
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
