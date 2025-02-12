package GraphAlgo.FlightRoutes;


import java.util.*;
class Main {
    static class Node{
        int node;
        long dist;
        public Node(int node, long dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();

        List<List<Node>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            long d=sc.nextLong();
            a--;
            b--;
            graph.get(a).add(new Node(b, d));
        }
        PriorityQueue<Long>[] distQ= new PriorityQueue[n];
        for(int i=0;i<n;i++) {
            distQ[i]= new PriorityQueue<>((a ,b)->Long.compare(b, a));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b)->Long.compare(a.dist, b.dist));

        pq.add(new Node(0, 0));


        while(!pq.isEmpty()){
            Node curr=pq.poll();
            int node=curr.node;
            long dis=curr.dist;

            for(Node neigh : graph.get(node)){
                int neighNode=neigh.node;
                long edgeDist=neigh.dist;

                int size=distQ[neighNode].size();
                if(size<k){
                    distQ[neighNode].offer(dis+edgeDist);
                    pq.add(new Node(neighNode, dis+edgeDist));
                }
                else{
                    long max=distQ[neighNode].peek();
                    if(dis+edgeDist > max) continue;
                    else{
                        distQ[neighNode].offer(dis+edgeDist);
                        distQ[neighNode].poll();
                        pq.add(new Node(neighNode, dis+edgeDist));
                    }
                }
            }


        }

        List<Long> res= new ArrayList<>();
        while(!distQ[n-1].isEmpty()){
            res.add(distQ[n-1].poll());
        }
        Collections.reverse(res);
        for(long el : res){
            System.out.print(el+ " ");
        }
    }
}