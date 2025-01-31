package Trees.TreeDistance_1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import java.util.Scanner;
import java.util.*;

public class Main {
    private static void dfs1(int node, int par, List<List<Integer>> tree, int[]down){
        for(int child : tree.get(node)){
            if(child!=par){
                dfs1(child, node, tree, down);
                down[node]=Math.max(down[node], 1+down[child]);
            }
        }
    }
    private static void dfs2(int node, int par, List<List<Integer>> tree, int[]down, int[]up){
        int max1=-1;
        int max2=-1;

        for(int child : tree.get(node)){
            if(child!=par){
                if(down[child]>=max1){
                    max2=max1;
                    max1=down[child];
                }
                else if(down[child]>max2) max2=down[child];
            }
        }

        for(int child : tree.get(node)){
            if(child!=par){
                int use= (down[child]==max1) ? max2: max1;
                up[child]=Math.max(1+up[node], 2+use);
                dfs2(child, node, tree, down, up);
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
        int[]down=new int[n];
        int[] up=new int[n];
        dfs1(0, -1, tree, down);
        dfs2(0, -1, tree, down, up);
        for(int i=0;i<n;i++){
            System.out.print(Math.max(down[i], up[i])+" ");
        }

    }
}