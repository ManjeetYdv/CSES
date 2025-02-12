package GraphAlgo.Monsters;
import java.sql.SQLOutput;
import java.util.*;
public class Main {
    static class Cell{
        int i;
        int j;
        Cell(int i, int j){
            this.i = i;
            this.j=j;
        }
    }
    static int[][]dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static  char[] dirr={'D', 'U', 'R', 'L'};
    static char curr='M';
    public static void bfs(Queue<int[]> queue, char[][] graph, int[][]minDist, char[][]parent){

        while(!queue.isEmpty()){
            int[]poll=queue.poll();
            int row=poll[0];
            int col=poll[1];
            int dist=poll[2];
            for(int i=0;i<4;i++){
                int nr=row+dir[i][0];
                int nc=col+dir[i][1];
                if(nr<0 || nc<0 || nr>=graph.length || nc>=graph[0].length ||  graph[nr][nc]!='.' || minDist[nr][nc]!=-1) continue;
                minDist[nr][nc]=dist+1;
                if(curr=='A') parent[nr][nc]=dirr[i];
                queue.add(new int[]{nr, nc, dist+1});
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        char[][]graph = new char[m][n];

        Queue<int[]> queue = new LinkedList<>();
        int arow=-1;
        int acol=-1;
        for(int i=0;i<m;i++){
            graph[i]=sc.next().toCharArray();
            for(int j=0;j<n;j++){
                if(graph[i][j]=='M') queue.add(new int[]{i,j, 0});
                else if(graph[i][j]=='A') {
                    arow=i; acol=j;
                    if(i==0 || j==n-1 || j==0 || i==m-1){
                        System.out.println("YES");
                        System.out.println(0);
                        return;
                    }
                }
            }
        }
       int[][]minDistForMonster = new int[m][n];
       int[][]minDistForA = new int[m][n];


       for(int []r : minDistForMonster) Arrays.fill(r,-1);
       for(int []r : minDistForA) Arrays.fill(r, -1);
       char[][]parent= new char[m][n];
       for(char []c : parent) Arrays.fill(c, 'X');
       bfs(queue, graph, minDistForMonster, parent );
       queue.add(new int[]{arow, acol, 0});
       curr='A';
       bfs(queue, graph, minDistForA, parent );

       boolean found=false;
       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               if(!(i == 0 || i == m - 1 || j == 0 || j == n - 1) || graph[i][j] == '#') continue;
                   if(minDistForA[i][j]==-1) continue;
                   else if(minDistForMonster[i][j]==-1 || minDistForA[i][j]<minDistForMonster[i][j]){
                       System.out.println("YES");
                       found=true;

                       //printing path
                       StringBuilder sb = new StringBuilder();
                       int curr_row=i;
                       int curr_col=j;
                       while(graph[curr_row][curr_col]!='A'){
                           char d =parent[curr_row][curr_col];
                           sb.append(d);
                           if(d=='U') curr_row++;
                           else if(d=='D') curr_row--;
                           else if(d=='R') curr_col--;
                           else if(d=='L') curr_col++;
                       }
                       sb=sb.reverse();
                       System.out.println(sb.length());
                       System.out.println(sb.toString());
                       return;
                   }
               }
           }
       if(!found) System.out.println("NO");

       }

    }

