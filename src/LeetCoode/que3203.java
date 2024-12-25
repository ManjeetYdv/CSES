package LeetCoode;
import java.util.*;
public class que3203 {
    public int diameter(List<List<Integer>> tree, int curr, int par, int[]diameter){
        int[]depth=new int[3];
        int ch=0;
        for(int child : tree.get(curr)){
            if(child!=par){
                depth[ch++]=diameter(tree, child, curr, diameter);
            }
        }
        int max=depth[0];
        max=Math.max(max, depth[0]+depth[1]);
        max=Math.max(max, depth[1]+depth[2]);
        max=Math.max(max, depth[0]+depth[2]);
        diameter[0]=Math.max(max, diameter[0]); //updating diameter

        return 1+Math.max(depth[0], Math.max(depth[1], depth[2]));
    }
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        List<List<Integer>> tree1= new ArrayList<>();
        List<List<Integer>> tree2= new ArrayList<>();

        int n=edges1.length+1;
        int m=edges2.length+1;

        for(int i=0;i<n;i++) tree1.add(new ArrayList<>());
        for(int i=0;i<m;i++) tree2.add(new ArrayList<>());
        for(int []e:edges1){
            tree1.get(e[0]).add(e[1]);
            tree1.get(e[1]).add(e[0]);
        }
        for(int []e:edges2){
            tree2.get(e[0]).add(e[1]);
            tree2.get(e[1]).add(e[0]);
        }

        int[]dia1= new int[1];
        int[]dia2=new int[1];
        int depth1=diameter(tree1, 0, -1, dia1);
        int depth2=diameter(tree2, 0, -1, dia2);

        int min1=(dia1[0]+1)/2;
        int min2=(dia2[0]+1)/2;

        return Math.max(min1+min2+1, Math.max(dia1[0], dia2[0]));
    }
    public static void main(String[] args) {

    }
}
