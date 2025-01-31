//package Trees.TreeDistance2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void dfs1(int node, int par, List<List<Integer>> tree, int[]downNodes){
        downNodes[node]=1;
        for(int child : tree.get(node)){
            if(child!=par){
                dfs1(child, node, tree, downNodes);
                downNodes[node]+=downNodes[child];
            }
        }
    }
    public static long dfs2(int node, int par, List<List<Integer>> tree, int[]downNodes){ //finding ans for root
        long res=0;
        for(int child : tree.get(node)){
            if(child!=par){
                res+=dfs2(child, node, tree, downNodes);
            }
        }
        return res+downNodes[node];
    }
    public static void dfs3(int node, int par, List<List<Integer>> tree, int[]downNodes, long[]res){
        long parentAns=res[par];
        int nodesAbove=tree.size()-downNodes[node];
        res[node]=parentAns+nodesAbove-downNodes[node];

        for(int child : tree.get(node)){
            if(child!=par){
                dfs3(child, node, tree, downNodes, res);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        List<List<Integer>> tree = new ArrayList<>();
        for(int i=0;i<n;i++){
            tree.add(new ArrayList<>());
        }

        for(int i=0;i<n-1;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            a--;
            b--;
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        long[] res=new long[n];
        int[]downNodes=new int[n];
        dfs1(0, -1, tree, downNodes);
        res[0]=dfs2(0, -1, tree, downNodes)-downNodes[0];

        for(int child: tree.get(0)){
            dfs3(child, 0, tree, downNodes, res);
        }
        for(int i=0;i<n;i++){
            System.out.print(res[i]+" ");
        }
    }
}
