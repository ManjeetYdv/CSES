package SegmentTree;
import java.util.*;
public class UniqueCharacterCounter {
    private Set<Character>[] segmentTree;
    private String input;

    @SuppressWarnings("unchecked")
    public UniqueCharacterCounter(String str) {
        this.input = str;
        int n = str.length();
        segmentTree = new HashSet[4 * n];
        buildTree(0, 0, n - 1);
    }

    // Build the segment tree
    private void buildTree(int node, int start, int end) {
        segmentTree[node] = new HashSet<>();
        if (start == end) {
            segmentTree[node].add(input.charAt(start));
        } else {
            int mid = start + (end - start) / 2;
            int leftChild = 2 * node + 1;
            int rightChild = 2 * node + 2;

            buildTree(leftChild, start, mid);
            buildTree(rightChild, mid + 1, end);

            segmentTree[node].addAll(segmentTree[leftChild]);
            segmentTree[node].addAll(segmentTree[rightChild]);
        }
    }

    // Query the segment tree for unique characters in a range
    public int query(int node, int start, int end, int left, int right) {
        // Completely outside the range
        if (start > right || end < left) {
            return 0;
        }

        // Completely inside the range
        if (start >= left && end <= right) {
            return segmentTree[node].size();
        }

        // Partially overlapping
        int mid = start + (end - start) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;

        // Combine results from left and right children
        Set<Character> resultSet = new HashSet<>();
        resultSet.addAll(segmentTree[leftChild]);
        resultSet.addAll(segmentTree[rightChild]);
        return resultSet.size();
    }

    public int countUniqueCharacters(int left, int right) {
        return query(0, 0, input.length() - 1, left, right - 1);
    }

    public static void main(String[] args) {
        String input = "hello world";
        UniqueCharacterCounter counter = new UniqueCharacterCounter(input);

        System.out.println(counter.countUniqueCharacters(0, 5));  // Output: 4
        System.out.println(counter.countUniqueCharacters(6, 11)); // Output: 5

    }
}