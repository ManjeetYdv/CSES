package GraphAlgo.BuildingTeams;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Main {
    public static boolean bfs(int node, List<List<Integer>> graph, int[]color){
        Queue<Integer> queue = new LinkedList<>();
        color[node]=1;
        queue.add(node);

        while(!queue.isEmpty()){
            int curr=queue.poll();
            int parentColor=color[curr];
            int newColor= parentColor==1?2:1;
            for(int neigh : graph.get(curr)){
                if(color[neigh]==parentColor) return false;
                if(color[neigh]==0){
                    color[neigh]=newColor;
                    queue.add(neigh);
                }
            }
        }
        return true;
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
        int[]color= new int[n];
        boolean possible=true;
        for(int i=0;i<n;i++){
            if(color[i]==0){
                if(!bfs(i, graph, color)){
                    System.out.println("IMPOSSIBLE");
                    possible=false;
                    break;
                }
            }
        }
        if(possible){
            for(int i=0;i<n;i++) System.out.print(color[i]+" ");
        }

    }
}
