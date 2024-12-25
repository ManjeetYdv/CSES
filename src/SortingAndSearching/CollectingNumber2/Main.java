////package SortingAndSearching.CollectingNumber2;
//
//import java.util.*;
//import java.io.*;
//
//public class Main {
//    static class FastReader{
//        BufferedReader br;
//        StringTokenizer st;
//        public FastReader(){
//            br=new BufferedReader(new InputStreamReader(System.in));
//        }
//        String next(){
//            while(st==null || !st.hasMoreTokens()){
//                try {
//                    st=new StringTokenizer(br.readLine());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            return st.nextToken();
//        }
//        int nextInt(){
//            return Integer.parseInt(next());
//        }
//        long nextLong(){
//            return Long.parseLong(next());
//        }
//        double nextDouble(){
//            return Double.parseDouble(next());
//        }
//        String nextLine(){
//            String str="";
//            try {
//                str=br.readLine().trim();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return str;
//        }
//    }
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
//    } private static int getRounds(int n, int[] pos) {
//        int rounds=1;
//        for(int i = 1; i< n; i++){
//            if(pos[i-1]> pos[i]) rounds++;
//        }
//        return rounds;
//    }
//    public static void main(String[] args) {
//        try {
//            FastReader in=new FastReader();
//            FastWriter out = new FastWriter();
//            int n=in.nextInt();
//            int m=in.nextInt();
//            int[]pos= new int[n];
//            int[]arr=new int[n];
//            for(int i=0; i<n ;i++){
//                int curr=in.nextInt();
//                arr[i]=curr;
//                pos[curr-1]=i;
//            }
//            for(int i=0;i<m;i++){
////                out.println("before");
////                for(int j=0;j<n;j++) out.print(arr[j]+" ");
////                out.println("");
////                for(int j=0;j<n;j++) out.print(pos[j]+" ");
////                out.println("");
//                int num1=in.nextInt();
//                int num2=in.nextInt();
//                int pos1= arr[num1-1]-1;
//                int pos2= arr[num2-1]-1;
//                //out.println("pos1 : "+pos1);
//               // out.println("pos2 : "+pos2);
//                int temp=pos[pos1];
//                pos[pos1]=pos[pos2];
//                pos[pos2]=temp;
//                if()
//
//                temp=arr[num1-1];
//                arr[num1-1]=arr[num2-1];
//                arr[num2-1]=temp;
//
////                out.println("after");
////                for(int j=0;j<n;j++) out.print(arr[j]+" ");
////                out.println("");
////                for(int j=0;j<n;j++) out.print(pos[j]+" ");
////                out.println("");
//                out.println(getRounds(n, pos));
//            }
//            out.close();
//        } catch (Exception e) {
//            return;
//        }
//    }
//}