package Trees.TreeDistance_1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static  void inDfs(int node, int parent, int[] in, List<List<Integer>> tree){
        for(int child : tree.get(node)){
            if(child!=parent){
                inDfs(child, node, in, tree);
                in[node]=Math.max(in[node], in[child]+1);
            }
        }
    }
    public static void outDfs(int node, int parent, int[]out, int []in, List<List<Integer>> tree){
        int max1=-1;
        int max2=-1;
        for(int child : tree.get(node)){
            if(child==parent) continue;
            if(in[child]>=max1){
                max2=max1;
                max1=in[child];
            }
            else if(in[child]>max2) max2=in[child];
        }

        for(int child: tree.get(node)){
            if(child!=parent){
                int use=(in[child]==max1? max2:max1);
                out[child]=Math.max(out[node]+1, use+2);
                outDfs(child, node, out, in, tree);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List<Integer>> tree= new ArrayList<>();
        int nodes=scanner.nextInt();
        for(int i=0;i<=nodes;i++){
            tree.add(new ArrayList<>());
        }

        for(int i=0;i<nodes-1;i++){
            int u=scanner.nextInt();
            int v=scanner.nextInt();
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        int[]in=new int[nodes+1];
        int[]out=new int[nodes+1];

        inDfs(1, -1, in, tree);
        outDfs(1, -1, out, in, tree);

        int[]ans=new int[nodes+1];
        for(int i=1;i<=nodes;i++){
            ans[i]=Math.max(in[i], out[i]);
            System.out.print(ans[i]+" ");
        }
    }
}

