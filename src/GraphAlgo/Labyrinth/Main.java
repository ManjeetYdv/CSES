//package GraphAlgo.Labyrinth;
import java.util.*;

public class Main {
    static class Cell {
        int row, col;
        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static boolean bfs(int r, int c, int destr, int destc, char[][] grid, int[][][] parent) {
        int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
        char[] d = { 'D', 'U', 'R', 'L' };
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(r, c));
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            int row = cell.row;
            int col = cell.col;

            if (row == destr && col == destc) return true;

            for (int i = 0; i < 4; i++) {
                int nrow = row + dir[i][0];
                int ncol = col + dir[i][1];

                if (nrow < 0 || ncol < 0 || nrow >= grid.length || ncol >= grid[0].length ||
                        visited[nrow][ncol] || grid[nrow][ncol] == '#') continue;

                visited[nrow][ncol] = true; // Mark as visited when adding to queue
                parent[nrow][ncol][0] = row;
                parent[nrow][ncol][1] = col;
                queue.add(new Cell(nrow, ncol));
            }
        }
        return false;
    }

    public static char giveDir(int r, int c, int parentR, int parentC) {
        int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
        char[] d = { 'D', 'U', 'R', 'L' };

        for (int i = 0; i < 4; i++) {
            int temp1=r-parentR;
            int temp2=c-parentC;
            int[] diddy = {temp1, temp2};
            if(Arrays.equals(diddy, dir[i])) return d[i];
        }
        return 'X';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] grid = new char[n][m];

        for (int i = 0; i < n; i++) {
            grid[i] = sc.next().toCharArray();
        }

        int r = -1, c = -1, destr = -1, destc = -1;
        int[][][] parent = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'A') {
                    r = i; c = j;
                } else if (grid[i][j] == 'B') {
                    destr = i; destc = j;
                }
                parent[i][j][0] = i;
                parent[i][j][1] = j;
            }
        }

        if (bfs(r, c, destr, destc, grid, parent)) {
            System.out.println("YES");
            int len =0;
            int destR = destr, destC = destc;
            StringBuilder sb = new StringBuilder();

            while (parent[destR][destC][0] != destR || parent[destR][destC][1] != destC) {
                len++;
                char dir = giveDir(destR, destC, parent[destR][destC][0], parent[destR][destC][1]);
                sb.append(dir);
                int tempR = parent[destR][destC][0];
                int tempC = parent[destR][destC][1];
                destR = tempR;
                destC = tempC;
            }
            System.out.println(len);
            System.out.println(sb.reverse().toString());
        } else {
            System.out.println("NO");
        }
    }
}
