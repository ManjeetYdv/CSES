package LeetCoode;
//class SegmentTree {
//
//    private static class Node {
//        int val;
//        int start;
//        int end;
//        Node left;
//        Node right;
//
//
//        public Node(int start, int end, int val) {
//            this.start = start;
//            this.end = end;
//            this.val = val;
//        }
//        public Node(int start, int end) {
//            this(start, end, 0);
//        }
//    }
//
//    private final Node root;
//
//    public SegmentTree(int[] arr) {
//        this.root = build(0, arr.length - 1, arr);
//    }
//
//    public int find(int start, int end) {
//        return this.find(this.root, start, end);
//    }
//    private Node build(int start, int end, int[] arr) {
//        if (start == end) {
//            // Base case: Leaf node (single element)
//            return new Node(start, end, arr[start]);
//        }
//
//        int mid = start + (end - start) / 2; // Find the middle index
//        Node node = new Node(start, end);
//        node.left = build(start, mid, arr);
//        node.right = build(mid + 1, end, arr);
//        node.val = Math.max(node.left.val ,node.right.val);
//        return node;
//    }
//
//    private int find(Node node, int start, int end) {
//        // No overlap: The range [start, end] does not intersect with this node's range
//        if (end < node.start || start > node.end) {
//            return Integer.MIN_VALUE;
//        }
//
//        // Full overlap: The range [start, end] fully contains this node's range
//        if (start <= node.start && end >= node.end) {
//            return node.val;
//        }
//
//        // Partial overlap: Query both left and right subtrees
//        int left = this.find(node.left, start, end);
//        int right = this.find(node.right, start, end);
//        return Math.max(left,right); // Combine the results
//    }
//
//
//}

class SparseTable {
    private int[][] table;
    private int[] log;

    // Build the Sparse Table
    public SparseTable(int[] arr) {
        int n = arr.length;
        int maxLog = (int) (Math.log(n) / Math.log(2)) + 1;

        // Initialize Sparse Table and Log Array
        table = new int[n][maxLog];
        log = new int[n + 1];

        // Precompute the logarithms
        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }

        // Build the table for the first level
        for (int i = 0; i < n; i++) {
            table[i][0] = arr[i];
        }

        // Build the Sparse Table for higher levels
        for (int j = 1; (1 << j) <= n; j++) {
            for (int i = 0; (i + (1 << j)) <= n; i++) {
                table[i][j] = Math.max(table[i][j - 1], table[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    // Query the maximum in range [L, R]
    public int query(int L, int R) {
        int j = log[R - L + 1];
        return Math.max(table[L][j], table[R - (1 << j) + 1][j]);
    }
}
public class que2940 {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n=heights.length;
        int q=queries.length;
        int []res= new int[q];
        int idx=0;
        SparseTable st = new SparseTable(heights);
        for(int []query : queries){
            int first=query[0];
            int second=query[1];
            if(first>second){
                int temp=first;
                first=second;
                second=temp;
            }

            if(first==second) res[idx++]=second;
            else if(heights[first]<heights[second]) res[idx++]=second;
            else{
                int max=Math.max(heights[first], heights[second]);
                int l=second+1;
                int r=n-1;
                int ans=-1;
                while(l<=r){
                    int mid=l+(r-l)/2;
                    int segmax=st.query(l, mid);
                    if(segmax> max){ans=mid; r=mid-1;}
                    else l=mid+1;
                }
                res[idx++]=ans;
            }
        }
        return res;
    }
}
