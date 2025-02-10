package GraphAlgo.RoundTrip;
import java.util.*;

public class Main {
    private static int[] cycle(int node, int par, List<List<Integer>>graph,int[]parent, boolean[]vis){
        parent[node]=par;
        vis[node]=true;

        for(int neigh : graph.get(node)){
            if(neigh==par) continue;
            else if(!vis[neigh]){
                int[]a = cycle(neigh, node, graph, parent, vis);
                if(a[0]!=-1) return a;
            }
            else return new int[]{neigh, node}; //start and end of cycle
        }
        return new int[]{-1, -1};
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
            graph.get(b).add(a);
        }
        boolean[] vis = new boolean[n];
        int[] par = new int[n];
        Arrays.fill(par, -1);
        int[] cycle= {-1, -1};
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                int[] cycleTemp = cycle(i, -1, graph, par, vis);
                if(cycleTemp[0]!=-1) {
                    cycle=cycleTemp;
                   // System.out.println(cycle[0]+" "+cycle[1]);
                    break;
                }
            }
        }
        if(cycle[0]!=-1) {
            int start=cycle[0];
            int end=cycle[1];
            List<Integer> path= new ArrayList<>();
            path.add(start);

            while(end!=start){
                path.add(end);
                end=par[end];
            }
            path.add(start);
            System.out.println(path.size());
            for(int el : path) System.out.print((el+1)+" ");
        }
        else System.out.println("IMPOSSIBLE");
    }
}

