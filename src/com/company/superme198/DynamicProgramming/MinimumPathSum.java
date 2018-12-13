package com.company.superme198.DynamicProgramming;

public class MinimumPathSum {

    static  int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] memo = new int[row][col];
        int[] ans = new int[]{99999999};
          minPathSumHelper(grid, memo, 0, 0,ans );
        return  ans[0];
    }

    static void minPathSumHelper(int[][] grid, int[][] memo, int r, int c, int[] ans){
        if(r == grid.length || r < 0|| c == grid[0].length || c <0 )
            return ;

        if(r == 0 && c == 0)
            memo[r][c] = grid[r][c];

        if(r == grid.length -1 && c == grid[0].length-1){
            ans[0] = Math.min(ans[0], memo[r][c]);
        }
        if(c>0){
            memo[r][c] += memo[r][c-1] + grid[r][c];
        }

         minPathSumHelper(grid, memo, r, c+1, ans);
        if(r>0){
            memo[r][c] += memo[r-1][c] + grid[r][c];
        }
       minPathSumHelper(grid, memo, r+1, c, ans);

        //return memo[r][c];
    }

    public static void main(String...args){
        System.out.println(minPathSum(new int[][]{{1,3,1},{1,5,1},{ 4,2,1}}));
    }
}
