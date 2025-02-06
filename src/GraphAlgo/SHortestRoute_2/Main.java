package GraphAlgo.SHortestRoute_2;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();
        int q= sc.nextInt();
        long[][]dist = new long[n][n];
        for(long []row : dist) Arrays.fill(row, Long.MAX_VALUE);
        for(int i=0;i<n;i++) dist[i][i]=0;

        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int d = sc.nextInt();
            a--; b--;
            dist[a][b]=Math.min(dist[a][b], d);
            dist[b][a]=Math.min(dist[b][a], d);
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i==j || dist[i][k]==Long.MAX_VALUE ||  dist[j][k]==Long.MAX_VALUE) continue;
                    if(dist[i][k]+dist[k][j] < dist[i][j]) dist[i][j]=dist[i][k]+dist[k][j];
                }
            }
        }
        for(int i=0;i<q;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            a--;
            b--;
            long d = dist[a][b]==Long.MAX_VALUE?-1 : dist[a][b];
            System.out.print(d+" " );
        }

    }
}
