package Introductory_Problems.AppleDivision;

import java.util.*;
import java.io.*;

public class Main {

    // FastReader class for efficient input
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

    // FastWriter class for efficient output
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

    // Recursive approach to calculate the minimum difference between two groups
    public static long giveMin(int index, long sum, int[] a, long total) {
        // Base case: if we've processed all elements, compute the difference
        if (index == a.length) {
            long other = total - sum;
            return Math.abs(other - sum);
        }
        // Recursively include or exclude the current apple in the subset
        return Math.min(
                giveMin(index + 1, sum + a[index], a, total), // Include current apple
                giveMin(index + 1, sum, a, total)            // Exclude current apple
        );
    }

    // Bitwise approach to calculate the minimum difference between two groups
    public static long giveMinBitwise(int[] a, long total) {
        int n = a.length;
        long ans = Long.MAX_VALUE; // Initialize the minimum difference to a large value

        // Iterate through all possible subsets using bitmasking
        for (int i = 0; i < (1 << n); i++) {
            long subsetSum = 0;
            for (int j = 0; j < n; j++) {
                // Check if the j-th element is included in the current subset
                if ((i & (1 << j)) != 0) {
                    subsetSum += a[j];
                }
            }
            long otherSum = total - subsetSum;
            ans = Math.min(ans, Math.abs(subsetSum - otherSum));
        }

        return ans; // Return the minimum difference
    }

    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();

            int n = in.nextInt(); // Read the number of apples
            int[] a = new int[n]; // Array to store the weights of the apples
            long totSum = 0; // Variable to store the total weight of all apples

            // Read the weights of apples and compute the total weight
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                totSum += a[i];
            }

            // Choose the method to solve the problem
            // Method 1: Recursive approach
            // long result = giveMin(0, 0, a, totSum);

            // Method 2: Bitwise approach
            long result = giveMinBitwise(a, totSum);

            // Print the result
            out.println(result);

            out.close(); // Close the FastWriter
        } catch (Exception e) {
            return;
        }
    }
}
