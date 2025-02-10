////package GraphAlgo.Monsters;
//import java.sql.SQLOutput;
//import java.util.*;
//public class Main {
//    static class Cell{
//        int i;
//        int j;
//        Cell(int i, int j){
//            this.i = i;
//            this.j=j;
//        }
//    }
//    static int[][]dir={{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//    static char[] d= {'D', 'U', 'R', 'L'};
//    static int a_i=-1;
//    static int a_j=-1;
//    public static boolean bfs(int r, int c, char[][]grid,  char[][]parents){
//       Queue<Cell> queue = new LinkedList<>();
//       boolean[][] visited = new boolean[grid.length][grid[0].length];
//       visited[r][c]=true;
//       queue.add(new Cell(r,c));
//       while(!queue.isEmpty()){
//           int size=queue.size();
//           boolean me=false;
//           boolean monster=false;
//           for(int i=0; i<size; i++){
//               Cell curr = queue.poll();
//               int row=curr.i;
//               int col=curr.j;
//
//               for(int j=0;j<4;j++){
//                   int nrow=row+dir[j][0];
//                   int ncol=col+dir[j][1];
//                   if(nrow<0 || ncol<0 || nrow>=grid.length || ncol>=grid[0].length || visited[nrow][ncol] || grid[nrow][ncol]=='#') continue;
//                   if(grid[nrow][ncol]=='.') queue.add(new Cell(nrow,ncol));
//                   visited[nrow][ncol]=true;
//                   parents[nrow][ncol]=d[j];
//                   if(grid[nrow][ncol]=='A') {
//                       me=true;
//                       a_i=nrow;
//                       a_j=ncol;
//                   }
//                   else if(grid[nrow][ncol]=='M') monster=true;
//               }
//           }
//           if(monster) return false;
//           else if(me) return true;
//       }
//       return false;
//    }
//    public static char oops(char ch){
//        switch (ch){
//            case 'U' : return 'D';
//            case 'D' : return 'U';
//            case 'R' : return 'L';
//            case 'L' : return 'R';
//        }
//        return 'X';
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int m=sc.nextInt();
//        int n=sc.nextInt();
//        char[][]graph = new char[m][n];
//        Queue<Cell> queue = new LinkedList<>();
//        List<Cell> list = new ArrayList<>();
//        for(int i=0;i<m;i++){
//            graph[i]=sc.next().toCharArray();
//            if(i==0 || i==m-1){
//                for(int j=0;j<n;j++){
//                    if(graph[i][j]=='.') list.add(new Cell(i, j));
//                    if(graph[i][j]=='A'){
//                        System.out.println("YES");
//                        System.out.println(0);
//                        return;
//                    }
//                }
//            }
//            else{
//                if(graph[i][0]=='.') list.add(new Cell(i, 0));
//                if(graph[i][n-1]=='.') list.add(new Cell(i, n-1));
//                if(graph[i][0]=='A' || graph[i][n-1]=='A') {
//                    System.out.println("YES");
//                    System.out.println(0);
//                    return;
//                }
//            }
//        }
//        if(list.size()==0) {
//            System.out.println("NO");
//            return;
//        }
//        boolean canReach=false;
//        char[][]parents = new char[m][n];
//        for(Cell c : list){
//            if(bfs(c.i, c.j, graph, parents)){
//                System.out.println("YES");
//                canReach=true;
//                //backtrack
//                int backtrack_i=a_i;
//                int backtrack_j=a_j;
//                StringBuilder sb = new StringBuilder();
//                while(backtrack_i!=c.i || backtrack_j!=c.j){
//                    char dir= parents[backtrack_i][backtrack_j];
//                    dir=oops(dir);
//                    sb.append(dir);
//
//                    if(dir=='U') backtrack_i--;
//                    else if (dir=='D') backtrack_i++;
//                    else if(dir=='L') backtrack_j--;
//                    else if(dir=='R') backtrack_j++;
//                }
//                System.out.println(sb.length());
//                System.out.println(sb.toString());
//                break;
//            }
//        }
//        if(!canReach) System.out.println("NO");
//    }
//}
