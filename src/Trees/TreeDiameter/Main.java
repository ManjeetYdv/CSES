package Trees.TreeDiameter;

import java.util.*;

public class Main {
    static int d=0;
    public static int helper(int node, int par, List<List<Integer>>tree){
        int max1=0;
        int max2=0;
        for(int child: tree.get(node)){
            if(child==par) continue;
            int h=helper(child, node, tree);
            if(h>=max1){
                max2=max1;
                max1=h;
            }
            else if(h>max2) max2=h;
        }
        d=Math.max(d, max1+max2);
        return max1+1;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        List<List<Integer>> tree = new ArrayList<>();
        for(int i=0;i<n;i++) tree.add(new ArrayList<>());

        for(int i=0;i<n-1;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            a--;b--;
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        helper(0, -1, tree);
        System.out.println(d);
    }
}
