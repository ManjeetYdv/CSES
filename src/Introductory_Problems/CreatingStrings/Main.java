package Introductory_Problems.CreatingStrings;

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

    public static void generatePermutations(char[]chars, boolean[]used, StringBuilder sb, List<String> result){
        if(sb.length()==chars.length) {
            result.add(sb.toString());
            return;
        }

        for(int i=0;i<chars.length;i++){
            if(used[i]) continue;
            if(i>0 && chars[i]==chars[i-1] && !used[i-1]) continue;

            used[i]=true;
            sb.append(chars[i]);
            generatePermutations(chars, used, sb, result);
            used[i]=false;
            sb.setLength(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();

            String str = in.nextLine();
            char[] chars = str.toCharArray();

            Arrays.sort(chars);

            // Initialize variables for permutation generation
            boolean[] used = new boolean[chars.length];
            StringBuilder current = new StringBuilder();
            List<String> result = new ArrayList<>();

            // Generate permutations
            generatePermutations(chars, used, current, result);

            // Output results
            out.println(result.size());
            for (String perm : result) {
                out.println(perm);
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


/////}