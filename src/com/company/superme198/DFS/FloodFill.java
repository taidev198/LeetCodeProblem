package com.company.superme198.DFS;

public class FloodFill {


    /**Link:https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1393/
     * An image is represented by a 2-D array of integers,
     * each integer representing the pixel value of the image (from 0 to 65535).
     * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill,
     * and a pixel value newColor, "flood fill" the image.
     * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on.
     * Replace the color of all of the aforementioned pixels with the newColor.
     * At the end, return the modified image.
     * Example 1:
     * Input:
     * image = [[1,1,1],[1,1,0],[1,0,1]]
     * sr = 1, sc = 1, newColor = 2
     * Output: [[2,2,2],[2,2,0],[2,0,1]]
     * Explanation:
     * From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
     * by a path of the same color as the starting pixel are colored with the new color.
     * Note the bottom corner is not colored 2, because it is not 4-directionally connected
     * to the starting pixel.
     * */
    static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int row = image.length;
        int col = image[0].length;
        boolean[][] visited = new boolean[row][col];
        markToNewColor(image, sr, sc, visited, newColor, image[sr][sc]);
        return image;
    }


    static void markToNewColor(int[][] matrix, int i, int j, boolean[][] visited, int newColor, int value){
        if(i < 0 || j < 0|| i>= matrix.length || j >= matrix[0].length||matrix[i][j] != value || visited[i][j] )
            return ;
        matrix[i][j] = newColor;
        visited[i][j] = true;
        markToNewColor(matrix, i+1,j,visited,  newColor, value);
        markToNewColor(matrix, i,j-1,visited,  newColor, value);
        markToNewColor(matrix, i,j+1,visited,  newColor, value);
        markToNewColor(matrix, i-1,j,visited,  newColor, value);

    }
}
