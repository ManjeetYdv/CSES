package Trees.TreeDistance_1;
import java.io.*;
import java.util.*;

public class TreeDistance1{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());

        // Initialize tree structure
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        // Input tree edges
        for (int i = 0; i < n - 1; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        // Initialize depth and ans arrays
        int[] depth = new int[n + 1];
        int[] ans = new int[n + 1];

        // Get the answers by passing the tree to the function
        calculateTreeDistances(tree, depth, ans, n);

        // Output the results
        for (int i = 1; i <= n; i++) {
            pw.print(ans[i] + " ");
        }
        pw.flush();
    }

    public static void calculateTreeDistances(
            ArrayList<ArrayList<Integer>> tree,
            int[] depth,
            int[] ans,
            int n
    ) {
        evalDepth(1, 0, tree, depth); // Evaluate depth for all nodes
        solve(1, 0, -1, tree, depth, ans); // Solve for all nodes
    }

    // Evaluate the depth of each node
    static void evalDepth(int src, int parent, ArrayList<ArrayList<Integer>> tree, int[] depth) {
        int srcDepth = 0;
        for (int child : tree.get(src)) {
            if (child != parent) {
                evalDepth(child, src, tree, depth);
                srcDepth = Math.max(srcDepth, 1 + depth[child]);
            }
        }
        depth[src] = srcDepth;
    }

    // Solve for the maximum distance for each node
    static void solve(
            int src,
            int parent,
            int parentAnswer,
            ArrayList<ArrayList<Integer>> tree,
            int[] depth,
            int[] ans
    ) {
        ArrayList<Integer> prefixMax = new ArrayList<>();
        ArrayList<Integer> suffixMax = new ArrayList<>();

        // Collect depth of children
        for (int child : tree.get(src)) {
            if (child != parent) {
                prefixMax.add(depth[child]);
                suffixMax.add(depth[child]);
            }
        }

        // Build prefix and suffix arrays
        for (int i = 1; i < prefixMax.size(); i++) {
            prefixMax.set(i, Math.max(prefixMax.get(i), prefixMax.get(i - 1)));
        }
        for (int i = suffixMax.size() - 2; i >= 0; i--) {
            suffixMax.set(i, Math.max(suffixMax.get(i), suffixMax.get(i + 1)));
        }

        // Evaluate answers for child nodes
        int childIndex = 0;
        for (int child : tree.get(src)) {
            if (child != parent) {
                int op1 = (childIndex == 0) ? Integer.MIN_VALUE : prefixMax.get(childIndex - 1);
                int op2 = (childIndex == suffixMax.size() - 1) ? Integer.MIN_VALUE : suffixMax.get(childIndex + 1);
                int partialAnswer = 1 + Math.max(parentAnswer, Math.max(op1, op2));

                solve(child, src, partialAnswer, tree, depth, ans);
                childIndex++;
            }
        }

        // Evaluate answer for the current node
        ans[src] = 1 + Math.max(parentAnswer, prefixMax.isEmpty() ? -1 : prefixMax.get(prefixMax.size() - 1));
    }
}
