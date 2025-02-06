package GraphAlgo.ShortedRoute1;
import java.util.*;

public class Main {
    static class Pair{
        int node;
        int dis;
        public Pair(int node, int dis){
            this.node = node;
            this.dis = dis;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int d=sc.nextInt();
            a--;b--;
            graph.get(a).add(new Pair(b, d));
        }
        int[]dis = new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[0]=0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->a.dis-b.dis);
        pq.add(new Pair(0, 0));
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int dist=p.dis;
            int node=p.node;
            if(dist>dis[node]) continue;
            for(Pair pair :graph.get(node)){
                int next=pair.node;
                int edge=pair.dis;
                if(dist+edge<dis[next]){
                    dis[next]=dist+edge;
                    pq.add(new Pair(next, dis[next]));
                }
            }
        }
        for(int i=0;i<n;i++) System.out.print(dis[i]+" ");
    }
}
