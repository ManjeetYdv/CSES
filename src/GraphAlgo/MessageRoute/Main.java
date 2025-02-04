////package GraphAlgo.MessageRoute;
//import java.util.*;
//public class Main {
//
//    public static boolean bfs(int src, int dest, List<List<Integer>> graph, int[]parent){
//        boolean[]visited = new boolean[graph.size()];
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(src);
//        visited[src] = true;
//        while(!queue.isEmpty()){
//            int cur = queue.poll();
//            if(cur==dest) return true;
//            for(int neigh : graph.get(cur)){
//                if(!visited[neigh]){
//                    visited[neigh] = true;
//                    parent[neigh]=cur;
//                    queue.add(neigh);
//                }
//            }
//        }
//        return false;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n=sc.nextInt();
//        int m=sc.nextInt();
//
//        List<List<Integer>> graph = new ArrayList<>();
//        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
//        for(int i=0;i<m;i++){
//            int a=sc.nextInt();
//            int b=sc.nextInt();
//            a--;b--;
//            graph.get(a).add(b);
//            graph.get(b).add(a);
//        }
//        int[] parent = new int[n];
//        for(int i=0;i<n;i++) parent[i]=i; //don't necessary in this since source is 0 and default value is 0 too
//        if(bfs(0, n-1, graph, parent)){
//            List<Integer> path = new ArrayList<>();
//            int len=1;
//            int idx=n-1;
//            while(parent[idx]!=idx){
//                len++;
//                path.add(idx);
//                idx=parent[idx];
//            }
//            path.add(idx);
//            Collections.reverse(path);
//            System.out.println(len);
//            for(int el : path) System.out.print((el+1)+" ");
//        }
//        else System.out.println("IMPOSSIBLE");
//    }
//}
