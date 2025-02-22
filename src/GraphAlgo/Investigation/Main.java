package GraphAlgo.Investigation;

import java.util.*;

public class Main {
    private static class Pair{
        int node;
        long dist;
        public Pair(int node, long dist){
            this.node = node;
            this.dist = dist;
        }
    }

    static final int mod=(int)1e9+7;
    private static void dijkstra(List<List<Pair>> graph,  long[]dist, int[]ways){
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b)->Long.compare(a.dist, b.dist));
        queue.add(new Pair(0, 0));
        dist[0]=0;
        ways[0]=1;

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int node=pair.node;
            long dis=pair.dist;
            if(dis > dist[node])continue;
            for(Pair neigh : graph.get(node)){
                int neighNode=neigh.node;
                long neighDist=neigh.dist+dis;
                if(neighDist < dist[neighNode]){
                    dist[neighNode]=neighDist;
                    ways[neighNode]=ways[node];
                    queue.add(new Pair(neighNode, neighDist));
                }
                else if(neighDist== dist[neighNode]){
                    ways[neighNode]=(ways[neighNode]+ways[node])%mod;
                }
            }
        }
    }
    private static long dfs(int node, List<List<Pair>> graph, int[]dp, long path, long []dist){ //
        if(node==graph.size()-1) return 0;
        if(dp[node]!=-1) return dp[node];

        long min=Integer.MAX_VALUE;
        for(Pair pair : graph.get(node) ){
            int neigh=pair.node;
            long dis=pair.dist;
            if(dis+path == dist[neigh]){
              // System.out.println("here");
                long mind= dfs(neigh, graph, dp, path+dis, dist);
              // System.out.println(mind);
                min=Math.min(min,mind+1);

            }
        }
        return dp[node]=(int)min;
    }
    private static long dfs2(int node,  List<List<Pair>> graph, int[]dp, long path, long []dist){
        if(node==graph.size()-1) return 0;
        if(dp[node]!=-1) return dp[node];

        long max=Integer.MIN_VALUE;
        for(Pair pair : graph.get(node) ){
            int neigh=pair.node;
            long dis=pair.dist;
            if(dis+path == dist[neigh]){
                long maxd=dfs2(neigh, graph, dp, path+dis, dist);
                max=Math.max(max, maxd+1);
            }
        }
        return dp[node]=(int)max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());

        for(int i=0;i<m;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            a--;b--;
            long c=sc.nextLong();
            graph.get(a).add(new Pair(b,c));
        }
        long[]dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        int[] ways = new int[n];

        dijkstra(graph, dist, ways);
        int[]shortest = new int[n];
        int[]longest = new int[n];
        Arrays.fill(shortest, -1);
        Arrays.fill(longest, -1);
        dfs(0,  graph, shortest, 0L, dist);
        dfs2(0, graph, longest, 0L, dist);
        System.out.println(dist[n-1]+" "+ ways[n-1]+" "+shortest[0]+" "+longest[0]);

    }
}
