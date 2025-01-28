package MeetInTheMiddle;

import java.util.ArrayList;
import java.util.List;

public class SubsetGenerator {

    public static List<List<Integer>> generateSubsets(int[] arr) {
        int n = arr.length;
        List<List<Integer>> subsets = new ArrayList<>();

        // Loop through all possible bitmasks (2^n subsets)
        for (int mask = 0; mask < (1 << n); mask++) {
            List<Integer> subset = new ArrayList<>();

            // Check each bit in the bitmask
            for (int j = 0; j < n; j++) {
                // If the j-th bit is set in the mask, include arr[j]
                if ((mask & (1 << j)) != 0) {
                    subset.add(arr[j]);
                }
            }

            // Add the subset to the list of subsets
            subsets.add(subset);
        }

        return subsets;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> subsets = generateSubsets(arr);

        // Print all subsets
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }


}