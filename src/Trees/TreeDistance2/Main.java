////package Trees.TreeDistance2;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Main {
//    public static void dfs1(int node, int par, List<List<Integer>>tree, long[]ans, int[]dp, int level){
//        ans[0]+=level;
//        for(int child: tree.get(node)){
//            if(child!=par){
//                dfs1(child,node, tree, ans, dp, level+1);
//                dp[node]+=dp[child]+1;
//            }
//        }
//    }
//    public static void dfs2(int node, int par, List<List<Integer>> tree, long[]ans, int[]dp){
//        for(int child: tree.get(node)){
//            if(child!=par){
//                ans[child]=ans[node]+tree.size()-2*dp[child]-2;
//                dfs2(child, node, tree, ans, dp);
//            }
//        }
//    }
//    public static void main(String[] args) {
//        Scanner sc= new Scanner(System.in);
//        int n= sc.nextInt();
//        List<List<Integer>> tree = new ArrayList<>();
//        for(int i=0;i<n;i++) tree.add(new ArrayList<>());
//
//        for(int i=0;i<n-1;i++){
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            a--;b--;
//            tree.get(a).add(b);
//            tree.get(b).add(a);
//        }
//        long[]ans = new long[n];
//        int[]dp = new int[n]; //bcche
//        dfs1(0, -1, tree, ans, dp, 0);
//        dfs2(0, -1, tree, ans, dp);
//        for(int i=0;i<n;i++){
//            System.out.print(ans[i]+" ");
//        }
//    }
//}
