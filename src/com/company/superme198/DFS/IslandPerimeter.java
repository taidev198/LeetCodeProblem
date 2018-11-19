package com.company.superme198.DFS;

/**
 * Created by traig on 4:21 PM, 11/19/2018
 */
public class IslandPerimeter {

    /**Link:https://leetcode.com/problems/island-perimeter/
     * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
     *
     * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
     * and there is exactly one island (i.e., one or more connected land cells).
     *
     * The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
     * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
     *
     *
     *
     * Example:
     *
     * Input:
     * [[0,1,0,0],
     *  [1,1,1,0],
     *  [0,1,0,0],
     *  [1,1,0,0]]
     *
     * Output: 16*/

    /***Solution1:using naive algorithm
     * Runtime: 559 ms, faster than 0.98% of Java online submissions for Island Perimeter.*/
    static int islandPerimeter(int[][] grid) {
        int perimeter =0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i=0; i< row; i++){
            for(int j =0; j< col; j++){
                if(grid[i][j] == 1){
                    perimeter += (4 - countNeigbors(grid, i, j));
                }
            }
        }
        return perimeter;

    }
    static int countNeigbors(int[][] grid, int r, int c){
        int count =0;
        if(r-1 >=0 && grid[r-1][c] == 1)
            count++;
        if(c-1 >=0 && grid[r][c-1] == 1)
            count++;
        if(r+1 < grid.length && grid[r+1][c] == 1)
            count++;
        if(c+1 < grid[0].length && grid[r][c+1] == 1)
            count++;
        System.out.println(count);
        return count;
    }
}
