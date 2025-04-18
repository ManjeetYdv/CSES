
package DP;

import java.util.*;

public class MoneySums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int c : arr) {
            for (int i = sum; i >= c; i--) {
                dp[i] = dp[i] || dp[i - c];
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= sum; i++) {
            if (dp[i]) {
                list.add(i);
            }
        }
        System.out.println(list.size());
        for (int el : list) System.out.print(el + " ");
    }
}
