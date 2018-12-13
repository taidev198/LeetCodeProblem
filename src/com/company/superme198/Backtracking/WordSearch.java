package com.company.superme198.Backtracking;

import java.util.*;

/**
 * Created by traig on 8:22 PM, 11/29/2018
 */
public class WordSearch {

   static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    static boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        for(int i= 0; i< row; i++){
            for(int j=0;j< col; j++){
                if(board[i][j] == word.charAt(0) )
                    queue.add(new Node(i, j));
                int k =0;
                while(!queue.isEmpty()){
                    Node cur = queue.poll();
                    visited[cur.x][cur.y] = true;
                    if(word.charAt(k) == board[cur.x][cur.y]){
                        k++;
                        if(k == word.length())
                            return true;
                        getNeighbors(board, cur, queue, visited, word);
                    }

                }
            }
        }
        return false;

    }
    static  void getNeighbors(char[][] matrix, Node node,  Queue<Node> queue, boolean[][] visited, String word) {
        List<Node> neighbors = new ArrayList<Node>();
        if(isValidPoint(matrix, node.x + 1, node.y, visited, word)) {
            queue.add(new Node(node.x + 1, node.y));
            visited[node.x+1][node.y] = true;
        }

        if(isValidPoint(matrix, node.x, node.y + 1, visited, word)) {
            queue.add(new Node(node.x, node.y + 1));
            visited[node.x][node.y+1] = true;
        }

        if(isValidPoint(matrix, node.x - 1, node.y, visited, word)) {
            queue.add(new Node(node.x - 1, node.y));
            visited[node.x-1][node.y] = true;
        }



        if(isValidPoint(matrix, node.x, node.y - 1, visited, word)) {
            queue.add(new Node(node.x, node.y - 1));
            visited[node.x][node.y-1] = true;
        }

    }

       static   boolean isValidPoint(char[][] matrix, int x, int y, boolean[][] visited, String word) {
           return (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length) && !visited[x][y];
       }

       public static void main(String...args){
           //System.out.println(exist(new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}}, "ABCCED"));
           Map<Integer, List<List<String>>> results = new HashMap<>();
           List<Map.Entry<Integer, List<List<String>>>> listResult = new ArrayList<>(results.entrySet());
           System.out.println(10 >> 2);

        }
   }
}
