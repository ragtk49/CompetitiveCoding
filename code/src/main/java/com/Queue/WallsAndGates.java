/*
 * Leetcode 286. Walls and Gates (https://leetcode.com/problems/walls-and-gates/)
 * You are given an m x n grid rooms initialized with these three possible values.
 * -1 A wall or an obstacle.
 * 0 A gate.
 * INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF
 * Fill each empty room with the distance to its nearest gate.
 */

package com.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    public void wallsAndGates(int[][] grid){
        int EMPTY = Integer.MAX_VALUE;
        int GATE = 0;
        int WALL = -1;
        /*
         * The DIRECTIONS array stores the coordinates of the adjacent cells
         * The adjacent cells are above, below, left and right
         * The coordinates are stored as an array of size 2
         */
        int[][] DIRECTIONS = {{1,0},{-1,0},{0,1},{0,-1}};

        int m = grid[0].length;
        int n = grid.length;

        /*
         * The queue is initialized as a LinkedList
         * The queue stores the coordinates of the gates
         * The coordinates are stored as an array of size 2
         */
        Queue<int[]> q =  new LinkedList();
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(grid[row][col] == GATE){
                    q.offer(new int[]{row, col});
                }
            }
        }

        /*
         * The BFS algorithm is used to find the distance of each empty room from the nearest gate
         * The queue is not empty as long as there are gates in the queue
         * The coordinates of the gates are stored in the queue
         * The coordinates are stored as an array of size 2
         * 
         */
        while(!q.isEmpty()){
            int[] room = q.poll();
            int row = room[0];
            int col = room[1];
            /*
             * The distance of each empty room from the nearest gate is calculated
             * The distance is stored in the grid
             */
            for(int[] direction : DIRECTIONS){
                int r = row + direction[0];
                int c = col + direction[1];
                /*
                 * If the coordinates are out of bounds or the cell is not empty, continue
                 * If the cell is a wall, continue
                 * If the cell is a gate, continue
                 * If the cell is empty, update the distance and add the coordinates to the queue
                 */
                if(r < 0 || c < 0 || r >= n || c >= m || grid[r][c] != EMPTY){
                    continue;
                }
                grid[r][c] = grid[row][col] +1;
                    q.offer(new int[]{r , c});
            }
        } 
    }

    public static void main(String[] args) {
        WallsAndGates w = new WallsAndGates();
        int[][] grid = {{Integer.MAX_VALUE,-1,0,Integer.MAX_VALUE},{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,-1},{Integer.MAX_VALUE,-1,Integer.MAX_VALUE,-1},{0,-1,Integer.MAX_VALUE,Integer.MAX_VALUE}};
        w.wallsAndGates(grid);
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length;j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}
