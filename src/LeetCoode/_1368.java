package LeetCoode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class _1368 {
    public record Cell(int row, int col){}
    public int minCost(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][]dist= new int[m][n];
        for(int[]row : dist) Arrays.fill(row, -1);
        dist[0][0]=1;
        int[][]dir={{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b)->Integer.compare(dist[a.row][a.col],dist[b.row][b.col]));
        pq.add(new Cell(0, 0));

        while(!pq.isEmpty()){
            Cell c=pq.peek();
            int row=c.row;
            int col=c.col;
            int dis=dist[row][col];

            int[]paths=new int[4];
            paths[grid[row][col]-1]=1;

            for(int i=0;i<4;i++){
                int nrow=row+dir[i][0];
                int ncol=col+dir[i][1];
                if(nrow<0 || ncol<0 || nrow>=m || ncol>=n) continue;
                int newD=dist[row][col]+ paths[i]==1?0:1;
                if(newD<dist[nrow][ncol]) {
                    dist[nrow][ncol]=newD;
                    pq.add(new Cell(nrow,ncol));
                }
            }
        }
        return dist[m-1][n-1];
    }
    public static void main(String[] args) {

    }
}
