//package GraphAlgo.RoundTrip;
import java.util.*;

public class Main {
    private static int[] detectCycle(int node,  boolean []vis, List<List<Integer>>  graph, int level, Map<Integer, Integer> map, int[]parent){
        map.put(node, level);
        vis[node]=true;
        level++;
        for(int child : graph.get(node)){
            if(!vis[child]){
                parent[child]=node;
                int[]a= detectCycle(child, vis, graph, level, map, parent);
                if(a[1]>2) return a;
            }
            else  {
                int firstOcc=map.get(child);
                int length=level-firstOcc;
             //   System.out.println("hello: "+child+" , length: "+length);
                if(length>2){ //length 2 for child parent relation
                    return new int[]{child, length, node}; //child is start of cycle and node is end of cycle and length is nodes in cycle
                }

            }
        }
        return new int[]{-1, -1, -1};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            a--;b--;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        boolean[]vis = new boolean[n];
        int[] thatCycleNode={-1, -1, -1};
        int[]parent=new int[n];
        for(int i=0;i<n;i++) parent[i]=i;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                int[] nodeAndLength= detectCycle(i, vis, graph, 0, new HashMap<>(), parent);

                if(nodeAndLength[1]>2) {
                    thatCycleNode[0]=nodeAndLength[0];
                    thatCycleNode[1]=nodeAndLength[1];
                    thatCycleNode[2]=nodeAndLength[2];
                    break;
                }
            }
        }
        if(thatCycleNode[0]==-1){
            System.out.println("IMPOSSIBLE");
        }
        else{
            int start=thatCycleNode[0];
            int node=thatCycleNode[2]; //end node
            System.out.println(thatCycleNode[1]+1);
            List<Integer> path = new ArrayList<>();
            path.add(start+1);
            for(int i=0;i<thatCycleNode[1]-1;i++){
                path.add(node+1);
                node=parent[node];
            }
            path.add(start+1);
            Collections.reverse(path);
            for(int el : path) System.out.print(el+" ");
        }
    }
}

