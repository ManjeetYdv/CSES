//package GraphAlgo.GameRoutes;
import java.util.*;
public class Main {
    static final int mod = (int)1e9+7;
    private static int dfs(int node, List<List<Integer>>graph, int[]dp){
        if(node==graph.size()-1){ return 1;}
        if(dp[node]!=-1) return dp[node];

        int count=0;
        for(int neigh : graph.get(node)){
            count= (count+dfs(neigh,graph,dp))%mod;
        }
        return dp[node]=count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> graph= new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            a--;b--;
            graph.get(a).add(b);
        }
        int[]dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(dfs(0, graph, dp));
    }
}
