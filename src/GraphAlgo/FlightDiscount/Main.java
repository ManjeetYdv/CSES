package GraphAlgo.FlightDiscount;

import java.util.*;

public class Main {
    private static class Cell{
        int node;
        long cost;
        public Cell(int node, long cost){
            this.node = node;
            this.cost = cost;
        }
    }
    private static long[]dijkstra(List<List<Cell>> graph, int src){
        long []costs = new long[graph.size()];
        Arrays.fill(costs, Long.MAX_VALUE);
        costs[src] = 0;
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b)->Long.compare(a.cost, b.cost));
        pq.add(new Cell(src, 0));
        while(!pq.isEmpty()){
            Cell cell = pq.poll();
            int node = cell.node;
            long cost = cell.cost;
            if(cost> costs[node]) continue;

            for(Cell c : graph.get(node)){
                int neigh=c.node;
                long neighCost =c.cost;
                if(cost+neighCost<costs[neigh]){
                    costs[neigh]=cost+neighCost;
                    pq.add(new Cell(neigh, costs[neigh]));
                }
            }
        }
        return costs;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        List<List<Cell>> graph = new ArrayList<>();
        List<List<Cell>> revGraph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
            revGraph.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int cost = sc.nextInt();
            src--;
            dest--;
            graph.get(src).add(new Cell(dest, cost));
            revGraph.get(dest).add(new Cell(src, cost));
        }
        long[] srcToAll = dijkstra(graph, 0);
        long[] destToAll = dijkstra(revGraph, n-1);

        long res=Long.MAX_VALUE;

//        for(int i=0;i<n;i++){
//            System.out.print(srcToAll[i]+" ");
//        }
//        System.out.println();
//        for(int i=0;i<n;i++) {
//            System.out.println(destToAll[i]+" ");
//        }
        for(int i=0;i<graph.size();i++){ //traversing all edges
            int u=i;
            for(Cell neigh : graph.get(i)){
                int v=neigh.node;
                long cost = neigh.cost;
                if(srcToAll[u]==Long.MAX_VALUE || destToAll[v]==Long.MAX_VALUE) continue;
                res=Math.min(res, srcToAll[u]+(cost/2)+destToAll[v]);
            }
        }
        System.out.println(res);
    }
}
