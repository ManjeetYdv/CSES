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
//    }
//
//    static class FastWriter {
//        private final BufferedWriter bw;
//
//        public FastWriter() {
//            bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        }
//
//        public void print(Object object) throws IOException {
//            bw.append(object.toString());
//        }
//
//        public void println(Object object) throws IOException {
//            bw.append(object.toString()).append("\n");
//        }
//
//        public void close() throws IOException {
//            bw.close();
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
//
//            // TreeMap to store ticket prices and counts
//            TreeMap<Integer, Integer> ticketMap = new TreeMap<>();
//
//            for (int i = 0; i < n; i++) {
//                int price = in.nextInt();
//                ticketMap.put(price, ticketMap.getOrDefault(price, 0) + 1);
//            }
//
//            for (int i = 0; i < m; i++) {
//                int bid = in.nextInt();
//                // Find the largest ticket price <= bid
//                Map.Entry<Integer, Integer> entry = ticketMap.floorEntry(bid);
//
//                if (entry == null) {
//                    out.print("-1 ");
//                } else {
//                    int ticketPrice = entry.getKey();
//                    out.println(ticketPrice+" ");
//
//                    // Update the count or remove the price
//                    if (entry.getValue() == 1) {
//                        ticketMap.remove(ticketPrice);
//                    } else {
//                        ticketMap.put(ticketPrice, entry.getValue() - 1);
//                    }
//                }
//            }
//
//            out.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
