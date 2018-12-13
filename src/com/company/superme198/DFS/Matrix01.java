package com.company.superme198.DFS;

import java.util.*;

public class Matrix01 {

    static int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] ans = new int[row][col];

        HashSet<Integer> set = new HashSet<>();
        for(int r = 0; r< row; r++){
            for(int c = 0; c< col; c++){
                if(matrix[r][c] == 0){
                    ans[r][c] = 0;
                    continue;
                }
                boolean[][] visited = new boolean[row][col];
                countDistance(matrix, r, c, visited, 0, set);
                ans[r][c] = Collections.min(set);
                set.clear();
            }
        }

        return ans;
    }


    static int[][] updateMatrix1(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        Queue<Object[]> demension = new LinkedList<>();

        int[][] ans = new int[row][col];
        for(int i=0; i< row; i++){
            for(int j = 0; j< col; j++){
                if(matrix[i][j] == 0)
                    ans[i][j] =0;
                else{
                    boolean[][] visited = new boolean[row][col];
                    ans[i][j] = distance(matrix, i, j, 0, visited);
                }
            }
        }
        return ans;
    }

    static int distance(int[][] matrix, int i, int j, int d, boolean[][] visited){
        if(i >= matrix.length || i <0 || j >= matrix[0].length || j <0 || visited[i][j])
            return d;
        visited[i][j] = true;
        System.out.println(d);
        if(matrix[i][j] == 0) return d;
        return  Math.min(Math.min(Math.min(distance(matrix, i+1, j, d+1, visited),
                distance(matrix, i-1, j, d+1, visited)),
                distance(matrix, i, j+1, d+1, visited)),
                distance(matrix, i, j-1, d+1, visited));

    }

    static void countDistance(int[][] matrix, int i, int j, boolean[][] visited, int distance, HashSet<Integer> set){
        if( i < 0 || j < 0|| i>= matrix.length || j >= matrix[0].length || matrix[i][j] == 0 || visited[i][j] ){
            if (distance != 0 && (i < 0 || j < 0|| i>= matrix.length || j >= matrix[0].length))
            set.add(distance);
        }else {
            visited[i][j] = true;
            countDistance(matrix, i+1,j, visited, distance +1 , set);
            countDistance(matrix, i,j-1, visited, distance +1, set);
            countDistance(matrix, i-1,j, visited, distance +1, set);
            countDistance(matrix, i,j+1, visited, distance +1, set);
        }
    }

    public static void main(String...args){


        System.out.println(Arrays.deepToString(updateMatrix(new int[][]{{0,0,0},{0,1,0},{1,1,1}})));
    }
}

