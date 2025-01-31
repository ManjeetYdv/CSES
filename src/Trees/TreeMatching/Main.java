package Trees.TreeMatching;
import java.util.*;

public class Main {
    public static void dfs(int node, List<List<Integer>> tree, int par, int[]dp1, int[]dp2){
        //not attaching link to child
        for(int child : tree.get(node)){
            if(child!=par){
                dfs(child, tree, node, dp1, dp2);
                dp2[node]+=Math.max(dp1[child], dp2[node]);
            }
        }
        int notAttaching=dp2[node];
        for(int child: tree.get(node)){
            if(child!=par){
                dp1[node]=Math.max(dp1[node], dp2[node]-Math.max(dp1[child], dp2[child])+ dp2[child]+1);
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

        int[]dp1=new int[n]; // with edge connecting to child
        int[]dp2=new int[n]; // with edge not connecting to child
        dfs(0, tree, -1, dp1, dp2);
        System.out.println(Math.max(dp1[0], dp2[0]));
    }
}