package GraphAlgo.RoundTrip_2;
import java.util.*;

public class Main {
    static int startNode=-1;
    static int endNode=-1;
    private static boolean hasCycle(int node, int par, List<List<Integer>> graph, boolean[]vis, boolean[]pathVis, int[]parent){
        vis[node]=true;
        pathVis[node]=true;
        parent[node]=par;

        for(int neigh: graph.get(node)){
            if(pathVis[neigh]){
                startNode=neigh;
                endNode=node;
                return true;
            }
            else if(!pathVis[neigh]) if(hasCycle(neigh, node, graph, vis, pathVis,parent)) return true;
        }
        pathVis[node]=false;
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            a--;
            b--;
            graph.get(a).add(b);
        }
        boolean[]vis = new boolean[n];
        boolean[] pathVis = new boolean[n];
        int[] parent = new int[n];
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                if(hasCycle(i, -1, graph, vis, pathVis, parent)) break;
            }
        }
        if(startNode!=-1){
            List<Integer>res = new ArrayList<>();
            res.add(startNode);
            int end=endNode;
            while(end!=startNode){
                res.add(end);
                end=parent[end];
            }
            res.add(startNode);
            Collections.reverse(res);
            System.out.println(res.size());
            for(int el : res) System.out.print(el+1+" ");
        }
        else System.out.println("IMPOSSIBLE");
    }
}
