package Trees.TreeDiameter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int ans=0;
    private static int depth(int node, int par, List<List<Integer>>tree){
        int depth=0;
        for(int child:tree.get(node)){
            if(child!=par){
                int d=depth(child, node, tree);
                ans=Math.max(ans, depth+d+1);
                depth=Math.max(depth, d+1);
            }
        }
        return depth;
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
        depth(0, -1, tree);
        System.out.println(ans);
    }
}
