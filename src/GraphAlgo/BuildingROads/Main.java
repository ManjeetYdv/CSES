package GraphAlgo.BuildingROads;
import java.util.*;

public class Main {
    static class DSU {
        int[] parent;
        int[] size;

        public DSU(int n) {
            parent=new int[n];
            size=new int[n];

            for(int i=0;i<n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }
        public int findPar(int n){
            if(parent[n]==n) return n;
            else return parent[n]=findPar(parent[n]);
        }
        public void union(int p, int q){
            int parentP=findPar(p);
            int parentQ=findPar(q);
            if(parentP==parentQ) return;

            if(size[parentP]<size[parentQ]){
                parent[parentP]=parentQ;
                size[parentQ]+=size[parentP];
            }
            else{
                parent[parentQ]=parentP;
                size[parentP]+=size[parentQ];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m= sc.nextInt();
        DSU dsu = new DSU(n);
        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            a--;
            b--;
            dsu.union(a, b);
        }
        int components=0;
        List<Integer> parents=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(dsu.parent[i]==i) {
                components++;
                parents.add(i);
            }
        }
        int needed=components-1;
        System.out.println(needed);
        for(int i=0;i<parents.size()-1;i++){
            System.out.println(parents.get(i)+" "+parents.get(i+1));
        }
        double s=-(double) 1e9;
    }
}
