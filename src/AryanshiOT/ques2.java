package AryanshiOT;

public class ques2 {
    private static int checkPattern(int[][] matrix, int r, int c, int dr, int dc) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int length = 0;
        boolean expectTwo = true; // Expect 2 after 1, then alternate between 0 and 2

        while (r >= 0 && r < rows && c >= 0 && c < cols) {
            if (length == 0) {
                // First element must be 1
                if (matrix[r][c] != 1) {
                    break;
                }
            } else {
                // Check alternation between 2 and 0
                if ((expectTwo && matrix[r][c] != 2) || (!expectTwo && matrix[r][c] != 0)) {
                    break;
                }
                expectTwo = !expectTwo; // Flip expectation for next element
            }
            length++;
            r += dr; // Move to the next row in the current direction
            c += dc; // Move to the next column in the current direction
        }

        return length;
    }

    public static int findLongestDiagonal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxLength = 0;

        // Traverse the entire matrix
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 1) { // Start only if the element is 1
                    // Check all 4 diagonal directions
                    maxLength = Math.max(maxLength, checkPattern(matrix, r, c, 1, 1));  // Down-right
                    maxLength = Math.max(maxLength, checkPattern(matrix, r, c, 1, -1)); // Down-left
                    maxLength = Math.max(maxLength, checkPattern(matrix, r, c, -1, 1)); // Up-right
                    maxLength = Math.max(maxLength, checkPattern(matrix, r, c, -1, -1));// Up-left
                }
            }
        }
        return maxLength; // Return the maximum length of the valid diagonal
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {2, 1, 2, 2, 0},
                {0, 2, 0, 2, 0},
                {0, 0, 0, 0, 0},
                {0, 2, 2, 2, 2},
                {2, 1, 2, 2, 1},
                {0, 2, 0, 0, 2}
        };

        // Find the longest diagonal length
        int result = findLongestDiagonal(matrix);

        // Print the result
        System.out.println("The longest diagonal length matching the pattern is: " + result);
    }

}
