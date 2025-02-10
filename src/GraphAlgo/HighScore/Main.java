package GraphAlgo.HighScore;

import java.util.*;

public class Main {
    static class Edge{
        int src;
        int dest;
        int weight;
        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight=weight;
        }
    }
    public static void dfs(int node, List<List<Integer>> graph, boolean[]reachable){
        reachable[node]=true;
        for(int neigh : graph.get(node)){
            if(!reachable[neigh]){
                dfs(neigh, graph, reachable);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Edge [] edges = new Edge[m];
        List<List<Integer>> revGraph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            revGraph.add(new ArrayList<>());
        }
        int idx=0;
        for(int i=0;i<m;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int weight=sc.nextInt();
            a--;b--;
            edges[idx++]= new Edge(a, b, weight);
            revGraph.get(b).add(a);
        }
        long[]weights = new long[n];
        Arrays.fill(weights, Long.MIN_VALUE);
        weights[0]=0;
        for(int i=0;i<n-1;i++){
            boolean update=false;
            for(Edge  e : edges){
                int src=e.src;
                int dest=e.dest;
                int weight=e.weight;
                if(weights[src]!=Long.MIN_VALUE &&  weights[src]+weight > weights[dest]){
                    weights[dest]=weights[src]+weight;
                    update=true;
                }
            }
            if(!update){break;}
        }
        //check if positive cycle from in path of n
        boolean[] reachable = new boolean[n];
        dfs(n-1, revGraph, reachable);
        for(Edge e : edges){
            int src=e.src;
            int dest=e.dest;
            int weight=e.weight;
            if(weights[src]!=Long.MIN_VALUE &&  weights[src]+weight > weights[dest] && reachable[dest]){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(weights[n-1]);
    }
}
