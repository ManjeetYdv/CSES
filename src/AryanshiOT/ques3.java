package AryanshiOT;

public class ques3 {
    public static String solution(String word) {
        int n = word.length();
        String smallest = word; // Start with the original word as the smallest

        // Iterate through all possible prefix and suffix reversals
        for (int k = 1; k <= n; k++) {
            // Reverse the first k characters
            String reversedPrefix = reverse(word.substring(0, k)) + word.substring(k);
            if (reversedPrefix.compareTo(smallest) < 0) {
                smallest = reversedPrefix;
            }

            // Reverse the last k characters
            String reversedSuffix = word.substring(0, n - k) + reverse(word.substring(n - k));
            if (reversedSuffix.compareTo(smallest) < 0) {
                smallest = reversedSuffix;
            }
        }

        return smallest;
    }

    // Helper to reverse a given string
    private static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        // Test case
        String word = "senior";
        System.out.println("Lexicographically smallest string: " + solution("dbaca"));
    }
}
