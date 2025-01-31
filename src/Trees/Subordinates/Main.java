package Trees.Subordinates;


import java.util.*;

public class Main {
    public static int dfs(int node, List<List<Integer>> tree, int[]res){
        int childs=0;
        for(int child: tree.get(node)){
            childs+=dfs(child, tree, res);
        }
        res[node]=childs;
        return childs+1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<List<Integer>> tree = new ArrayList<>();
        for(int i=0;i<n;i++){
            tree.add(new ArrayList<>());
        }

        for(int i=2;i<=n ;i++){
            int par=sc.nextInt();
            tree.get(par-1).add(i-1);
        }
        int[]res= new int[n];
        dfs(0, tree, res);
        for(int i=0;i<n;i++){
            System.out.print(res[i]+" ");
        }
    }
}
