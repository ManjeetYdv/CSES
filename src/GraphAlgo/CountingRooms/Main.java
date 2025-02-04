//import java.util.*;
//import java.io.*;
//
//public class Main {
//    static class FastReader {
//        BufferedReader br;
//        StringTokenizer st;
//
//        public FastReader() {
//            br = new BufferedReader(new InputStreamReader(System.in));
//        }
//
//        String next() {
//            while (st == null || !st.hasMoreTokens()) {
//                try {
//                    st = new StringTokenizer(br.readLine());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            return st.nextToken();
//        }
//
//        int nextInt() {
//            return Integer.parseInt(next());
//        }
//
//        long nextLong() {
//            return Long.parseLong(next());
//        }
//
//        double nextDouble() {
//            return Double.parseDouble(next());
//        }
//
//        String nextLine() {
//            String str = "";
//            try {
//                str = br.readLine().trim();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return str;
//        }
//    }
//
//    static class FastWriter {
//        private final BufferedWriter bw;
//
//        public FastWriter() {
//            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        }
//
//        public void print(Object object) throws IOException {
//            bw.append("" + object);
//        }
//
//        public void println(Object object) throws IOException {
//            print(object);
//            bw.append("\n");
//        }
//
//        public void close() throws IOException {
//            bw.close();
//        }
//    }
//
//    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//
//    private static void dfs(int r, int c, int n, int m, char[][] grid) {
//        if (r < 0 || c < 0 || r >= n || c >= m || grid[r][c] == '#') return;
//        grid[r][c] = '#'; // Mark as visited
//
//        for (int[] d : dir) {
//            dfs(r + d[0], c + d[1], n, m, grid);
//        }
//    }
//
//    public static void main(String[] args) {
//        try {
//            FastReader in = new FastReader();
//            FastWriter out = new FastWriter();
//
//            int n = in.nextInt();
//            int m = in.nextInt();
//            char[][] grid = new char[n][m];
//
//            for (int i = 0; i < n; i++) {
//                grid[i] = in.next().toCharArray();
//            }
//
//            int count = 0;
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    if (grid[i][j] == '.') {
//                        count++;
//                        dfs(i, j, n, m, grid);
//                    }
//                }
//            }
//
//            out.println(count);
//            out.close();
//        } catch (Exception e) {
//            return;
//        }
//    }
//}
