package GraphAlgo.CycleFinding;
import java.util.*;
public class Main {
    private static class Node{
        int node;
        long dist;

        public Node(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    static int endNode=-1;
    public static boolean dfs(int startNode, int node, List<List<Node>> graph, boolean[] visited, int par, int[] parent, long dist) {
        visited[node] = true;
        parent[node]=par;
        for(Node n : graph.get(node)){
            int neigh=n.node;
            long dis=n.dist;

            if(!visited[n.node]){
                if(dfs(startNode, n.node, graph, visited, node, parent, dist+dis)) return true;
            }
            else if(neigh==startNode && dist+dis<0){
                 //System.out.println("hereeeeee");
                endNode=node;
               // System.out.println("end node updated to "+endNode);
                return true;
            }
        }
        visited[node]=false;
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        List<List<Node>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());

        for(int i=0;i<m;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            long c= sc.nextLong();
            a--;b--;
            graph.get(a).add(new Node(b, c));
        }
//        int n=4;
//        int m=5;
//        List<List<Node>> graph = new ArrayList<>();
//        for (int i = 0; i < 4; i++) graph.add(new ArrayList<>()); // Assuming max node index is 4
//
//        graph.get(0).add(new Node(0, 0));
//        graph.get(1).add(new Node(0, 3));
//        graph.get(1).add(new Node(1, -1));
//        graph.get(2).add(new Node(3, 3));
//        graph.get(3).add(new Node(1, 6));

        long[]dist=  new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        for(int k=0;k<n;k++){
            if(dist[k]!=Long.MAX_VALUE) continue;;
            dist[k]=0;
            for(int i=0;i<n-1;i++){
                //iterate all edges
                for(int j=0;j<n;j++){
                    if(dist[j]== Long.MAX_VALUE) continue;
                    for(Node neighNode : graph.get(j)){
                        int neigh=neighNode.node;
                        long dis=neighNode.dist;
                        if(dist[j]+dis < dist[neigh]){
                            dist[neigh]=dist[j]+dis;
                        }
                    }
                }
            }
        }

        int node=-1;
        for(int j=0;j<n;j++){
            if(dist[j]== Long.MAX_VALUE) continue;
            for(Node neighNode : graph.get(j)){
                int neigh=neighNode.node;
                long dis=neighNode.dist;
                if(dist[j]+dis < dist[neigh]){
                    node=j;
                    break;
                }
            }
        }
        if(node!=-1){
           // System.out.println(node);
            int[] parent=new int[n];
            dfs(node, node, graph, new boolean[n], -1, parent, 0L);
           // System.out.println("endnode is : "+ endNode);
            List<Integer> cycle = new ArrayList<>();
            cycle.add(node+1);

            int currNode=endNode;
            while(currNode!=node){
                cycle.add(currNode+1);
                currNode=parent[currNode];
            }
            cycle.add(node+1);
            Collections.reverse(cycle);
            System.out.println("YES");
            for(int el : cycle) System.out.print(el+" ") ;
            return;
        }
        else{
            System.out.println("NO");
        }
    }
}
