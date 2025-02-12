package GraphAlgo.LongestFlightRoute;
import java.util.*;
public class Main {

    public static int dfs(int node, int dest, int[]child, List<List<Integer>> graph, int[]dp){
        if(node==dest) return 1;
        if(dp[node]!=-1) return dp[node];
        int len=0;
        for(int neigh : graph.get(node)){
            int thisPath = dfs(neigh, dest,child, graph, dp);
            if(thisPath==0) continue;
            thisPath++;
            if(thisPath > len){
                child[node]= neigh;
                len=thisPath;
            }
        }
        return dp[node]=len;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> graph = new ArrayList<>();
        int n=sc.nextInt();
        int m=sc.nextInt();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            a--;
            b--;
            graph.get(a).add(b);
        }
        int[] child = new int[n];
        int[] dp = new int[n];
        Arrays.fill(dp, -1);;
        dfs(0, n-1, child, graph, dp);

        if(dp[0]>0){
            System.out.println(dp[0]);
            List<Integer> path = new ArrayList<>();
            int curr=0;
            while(curr!=n-1){
                path.add(curr);
                curr=child[curr];
            }
            path.add(n-1);
            Collections.reverse(path);
            for(int el : path) System.out.print(el+1+" ");
        }
        else System.out.println("IMPOSSIBLE");
    }
}