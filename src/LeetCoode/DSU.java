package LeetCoode;

public class DSU {
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
    public static void main(String[] args) {

    }
}
