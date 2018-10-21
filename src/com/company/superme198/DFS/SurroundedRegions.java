package com.company.superme198.DFS;

public class SurroundedRegions {

    /**Link:https://leetcode.com/problems/surrounded-regions/description/
     * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
     *
     * A region is captured by flipping all 'O's into 'X's in that surrounded region.
     *
     * Example:
     *
     * X X X X
     * X O O X
     * X X O X
     * X O X X
     * After running your function, the board should be:
     *
     * X X X X
     * X X X X
     * X X X X
     * X O X X
     * Explanation:
     * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'.
     * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
     * Two cells are connected if they are adjacent cells connected horizontally or vertically.
     *
     * */
    static void solve(char[][] board) {
        int row = board.length;
        if(row == 0)
            return;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        //disable to flip on the border
        for(int c = 0; c< col; c++)
            flip(board, 0, c, visited, false);
        for(int c = 0; c< col; c++)
            flip(board, row-1, c, visited, false);
        for(int r = 0; r< row; r++)
            flip(board, r, 0, visited, false);
        for(int r = 0; r< row; r++)
            flip(board, r, col-1, visited, false);

        for(int r = 1; r < row -1; r++){
            for(int c =1; c < col -1; c++){
                if(board[r][c] == 'O'){

                    flip(board, r, c, visited, true);
                }
            }
        }

        for(int r = 0; r < row; r++){
            for(int c =0; c < col; c++){
                System.out.print(board[r][c]+" ");
            }
            System.out.println();
        }
    }

    static void flip(char[][] board,int r, int c, boolean[][] visited, boolean isFlipped){
        if(r <0 || c <0 || r >= board.length || c >= board[0].length || board[r][c] == 'X'|| visited[r][c])
            return ;
        if (isFlipped){
            board[r][c] = 'X';
        }

        visited[r][c] = true;
        flip(board, r-1, c, visited, isFlipped);
        flip(board, r+1, c, visited, isFlipped);
        flip(board, r, c-1, visited, isFlipped);
        flip(board, r, c+1, visited, isFlipped);

    }

    public static void main(String...args){
        solve(new char[][]{{'O','O','O'},{'O','O','O'},{'O','O','O'}});
    }
}
