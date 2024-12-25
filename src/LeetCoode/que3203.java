package LeetCoode;
import java.util.*;
public class que3203 {
//    public int diameter(List<List<Integer>> tree, int curr, int par, int[]diameter){
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for(int child : tree.get(curr)){
//            if(child!=par){
//                int d=diameter(tree, child, curr, diameter);
//                pq.add(d);
//                if(pq.size()>2) pq.poll();
//            }
//        }
//        if(pq.size()==0) return 1; //leafe node
//        int maxChild1=pq.poll();
//        int maxChild2= (pq.isEmpty()?0 : pq.poll());
//
//        diameter[0]=Math.max(diameter[0],maxChild1+maxChild2);
//        return 1+Math.max(maxChild1, maxChild2);
//    }
//    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
//        List<List<Integer>> tree1= new ArrayList<>();
//        List<List<Integer>> tree2= new ArrayList<>();
//
//        int n=edges1.length+1;
//        int m=edges2.length+1;
//
//        for(int i=0;i<n;i++) tree1.add(new ArrayList<>());
//        for(int i=0;i<m;i++) tree2.add(new ArrayList<>());
//        for(int []e:edges1){
//            tree1.get(e[0]).add(e[1]);
//            tree1.get(e[1]).add(e[0]);
//        }
//        for(int []e:edges2){
//            tree2.get(e[0]).add(e[1]);
//            tree2.get(e[1]).add(e[0]);
//        }
//
//        int[]dia1= new int[1];
//        int[]dia2=new int[1];
//        int depth1=diameter(tree1, 0, -1, dia1);
//        int depth2=diameter(tree2, 0, -1, dia2);
//
//        int min1=(dia1[0]+1)/2;
//        int min2=(dia2[0]+1)/2;
//
//        return Math.max(min1+min2+1, Math.max(dia1[0], dia2[0]));
//    }
    public record Pair(int node, int parent){}
    public record NodeAndDist(int node, int dist){}
    public NodeAndDist giveOneEnd(List<List<Integer>> tree, int node){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(node, -1));

        int dist=-1;
        int endNode=-1;
        while(!queue.isEmpty()){
            int size=queue.size();
            dist++;
            for(int i=0;i<size;i++){
                Pair p=queue.poll();
                int curr=p.node;
                int par=p.parent;
                endNode=curr;
                for(int child : tree.get(curr)){
                    if(child!=par){
                        queue.add(new Pair(child, curr));
                    }
                }
            }
        }
        return new NodeAndDist(endNode, dist);
    }
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        List<List<Integer>> tree1= new ArrayList<>();
        List<List<Integer>> tree2= new ArrayList<>();

        for(int i=0;i<edges1.length;i++) tree1.add(new ArrayList<>());
        for(int i=0;i<edges2.length;i++) tree2.add(new ArrayList<>());

        for(int[]edge:edges1){
            tree1.get(edge[0]).add(edge[1]);
            tree1.get(edge[1]).add(edge[0]);
        }
        for(int []e:edges2){
            tree2.get(e[0]).add(e[1]);
            tree2.get(e[1]).add(e[0]);
        }

        NodeAndDist end1Tree1=giveOneEnd(tree1, 0);
        NodeAndDist end2Tree1=giveOneEnd(tree1,end1Tree1.node);

        int dia1=end2Tree1.dist;

        NodeAndDist end1Tree2=giveOneEnd(tree2, 0);
        NodeAndDist end2Tree2=giveOneEnd(tree2,end1Tree2.node);

        int dia2=end2Tree2.dist;

        int min=(dia1+1)/2 + (dia2+1)/2;
        return Math.max(min, Math.max(dia1, dia2));

    }
    public static void main(String[] args) {

    }
}
