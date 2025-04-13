package Trees.Subordinates;
import java.util.*;
public class Main2 {
    public static void helper(int node, List<List<Integer>>tree, int[]down){
        for(int child: tree.get(node)){
            helper(child, tree, down);
            down[node]=down[child]+1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        List<List<Integer>> tree = new ArrayList<>();
        for(int i=0;i<n;i++){
            tree.add(new ArrayList<>());
        }
        for(int i=1;i<n;i++){
            int par=sc.nextInt();
            par--;
            tree.get(par).add(i);
        }
        int[]res= new int[n];
        helper(0,tree,res);
        for(int i=0;i<n;i++){
            System.out.print(res[i]+" ");
        }
    }
}
