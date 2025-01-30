package LeetCoode;
class DSU {
    int[] parent;
    int[] size;

    public DSU(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findPar(int n) {
        if (parent[n] == n) return n;
        else return parent[n] = findPar(parent[n]);
    }

    public boolean union(int p, int q) {
        int parentP = findPar(p);
        int parentQ = findPar(q);
        if (parentP == parentQ) return false;

        if (size[parentP] < size[parentQ]) {
            parent[parentP] = parentQ;
            size[parentQ] += size[parentP];
        } else {
            parent[parentQ] = parentP;
            size[parentP] += size[parentQ];
        }
        return true;
    }
}

public class _684 {
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length+1);
        int[] res= new int[2];

        for(int []edge : edges){
            int a =edge[0];
            int b =edge[1];
            if(!dsu.union(a, b)){
                res[0]=edge[0];
                res[1]=edge[1];
            }
        }
        return res;
    }
}
