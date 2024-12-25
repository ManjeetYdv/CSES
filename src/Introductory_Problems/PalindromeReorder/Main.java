package Introductory_Problems.PalindromeReorder;

import java.io.*;
import java.util.StringTokenizer;

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
            String str=in.nextLine();
            int len=str.length();
            int[]f=new int[26];

            for(char ch: str.toCharArray()) f[ch-'A']++;

            int odds=0;
            //check if possible
            for(int i=0;i<26;i++){
                if(f[i]%2==1) odds++;
                if(odds>1){
                    out.println("NO SOLUTION");
                    out.close();
                    return;
                }
            }
            char mid=' ';
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++){
                if(f[i]%2==1) mid=(char)(i+'A');
                else{
                    int times=f[i]/2;
                    for(int j=0;j<times;j++) sb.append((char)(i+'A'));
                }
            }
            String middle="";
            if(mid!=' '){
                int fq=f[mid-'A'];
                StringBuilder midSb = new StringBuilder();
                for(int i=0;i<fq;i++) midSb.append(mid);
                middle=midSb.toString();
            }
            String leftPart=sb.toString();
            String rightPart= sb.reverse().toString();

            String pal = leftPart+middle+rightPart;
            out.println(pal);

            out.close();
        } catch (Exception e) {
            return;
        }
    }
}