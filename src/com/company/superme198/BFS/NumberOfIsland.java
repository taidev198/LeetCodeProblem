package com.company.superme198.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {


    /**Link:*/

     /**Solution :Using Breath First Search*/
   static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int numIslands(char[][] grid) {
        if(grid == null) return 0;
        int isLandCount =0;

        Queue<Node> queue = new LinkedList<>();
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[r].length; c++){
                if(grid[r][c] == '1'){
                    isLandCount++;
                    queue.add(new Node(r, c));
                    while(!queue.isEmpty()){
                        Node cur = queue.poll();
                        grid[cur.x][cur.y] = '0';
                        getNeighbors(grid, cur, queue);
                    }

                }
            }
        }
        return isLandCount;
    }


    static   void getNeighbors(char[][] matrix, Node node,  Queue<Node> queue) {
        if(isValidPoint(matrix, node.x - 1, node.y)) {
            queue.add(new Node(node.x - 1, node.y));
            matrix[node.x-1][node.y] = '0';
        }

        if(isValidPoint(matrix, node.x + 1, node.y)) {
            queue.add(new Node(node.x + 1, node.y));
            matrix[node.x+1][node.y] = '0';
        }

        if(isValidPoint(matrix, node.x, node.y - 1)) {
            queue.add(new Node(node.x, node.y - 1));
            matrix[node.x][node.y-1] = '0';
        }

        if(isValidPoint(matrix, node.x, node.y + 1)) {
            queue.add(new Node(node.x, node.y + 1));
            matrix[node.x][node.y+1] = '0';
        }

    }

    static   boolean isValidPoint(char[][] matrix, int x, int y) {
        if ((x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) || (matrix[x][y] == '0'))
            return false;
        return true;
    }

}
