/*
 * Leetcode: 200. Number of Islands (https://leetcode.com/problems/number-of-islands/)
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
 * return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 */

package com.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public int numIslands(char[][]grid){

        if(grid == null || grid.length == 0){
            return 0;
        }
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int directions[][] = {{1,0},{-1,0},{0,1},{0,-1}}; // stores the coordinates of the adjacent cells
        Queue<int[]> queue = new LinkedList(); // queue stores the coordinates of the islands

        /*
         * The BFS algorithm is used to find the number of islands
         * The queue is not empty as long as there are islands in the queue
         * The coordinates of the islands are stored in the queue
         */
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(grid[row][col] == '1'){ // if the cell is an island
                    count++;              // increment the count
                    grid[row][col] = '0'; // mark the cell as visited
                    queue.offer(new int[]{row, col}); // add the coordinates of the island to the queue
                }
                /*
                 * The queue is not empty as long as there are islands in the queue
                 * The coordinates of the islands are stored in the queue
                 * The coordinates are stored as an array of size 2
                 */
                while(!queue.isEmpty()){
                    int[] cell = queue.poll();
                    int currRow = cell[0];
                    int currCol = cell[1];

                    for(int[] direction : directions){
                        int newRow = currRow + direction[0];
                        int newCol = currCol + direction[1];
                        /*
                         * If the coordinates are out of bounds or the cell is not an island, continue
                         * If the cell is an island, mark the cell as visited and add the coordinates to the queue
                         */
                        if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == '1'){
                            grid[newRow][newCol] = '0';
                            queue.offer(new int[]{newRow, newCol});
                        }

                    }
                }
            }
        }
        return count; // return the number of islands
        
    }

    public static void main(String[] args) {
        NumberOfIslands n = new NumberOfIslands();
        char[][] grid = {{'1','1','1','1','0'},
                         {'1','1','0','1','0'},
                         {'1','1','0','0','0'},
                         {'0','0','0','0','0'}};
        System.out.println(n.numIslands(grid)); // 1

        char[][] grid2 = {{'1','1','0','0','0'},
                          {'1','1','0','0','0'},
                          {'0','0','1','0','0'},
                          {'0','0','0','1','1'}};
        System.out.println(n.numIslands(grid2)); // 3
    }
    
}


