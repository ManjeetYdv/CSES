package SortingAndSearching.NestedRangesCheck;


import java.util.*;
import java.io.*;

public class Main {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine().trim();
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
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();
            int n = in.nextInt();
            List<int[]> list = new ArrayList<>();
            int index = 0;
            while (n-- > 0) {
                int start = in.nextInt();
                int end = in.nextInt();
                list.add(new int[]{start, end, index});
                index++;
            }
            Collections.sort(list, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
            int[] overShadowed = new int[list.size()];

            int maxEnd = -1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i)[1] <= maxEnd) {
                    overShadowed[list.get(i)[2]] = 1;
                } else maxEnd = Math.max(maxEnd, list.get(i)[1]);
            }

            Collections.sort(list, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
            int[] overShadows = new int[list.size()];
            int minEnd = (int) 1e9;
            for (int i = 0; i < list.size(); i++) {
                int currEnd = list.get(i)[1];
                int idx = list.get(i)[2];

                if (currEnd < minEnd) {
                    minEnd = currEnd;
                } else overShadows[idx] = 1;
            }
            for (int i = 0; i < overShadows.length; i++) {
                out.print(overShadows[i] + " ");
            }
            out.println(" ");
            for (int i = 0; i < overShadowed.length; i++) {
                out.print(overShadowed[i] + " ");
            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}