package com.company.superme198.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by traig on 5:06 PM, 12/17/2018
 */
public class NQueens {


    /**Link:https://leetcode.com/problems/n-queens/*/
    public List<List<String>> solveNQueens(int n) {
        // if(n == 1)
        //     return new int[][]{{1}};
        boolean[][] visited =  new boolean[n][n];
        List<int[]> ans = new ArrayList<>();
        List<List<String>> chosen = new ArrayList<>();
        generateQueens(n,visited, ans, chosen, 0);

        return chosen;
    }

    public void generateQueens(int n, boolean[][] visited,List<int[]>  ans,  List<List<String>> chosen, int row){
        if (row == n){
            List<String> rowAns = new ArrayList<>();
            for(int i=0; i< n;i++){
                char[] temp = new char[n];
                Arrays.fill(temp, '.');
                temp[ans.get(i)[1]] = 'Q';
                rowAns.add(new String(temp));
            }
            chosen.add(new ArrayList<>(rowAns));

        }
        else {
            for(int i =0; i< n; i++){
                if (!visited[row][i]){
                    boolean ok= true;
                    for (int[] an : ans) {
                        //   System.out.println("row:" + k + " col:" + ans[k]);
                        if (!isValid(row, i, an[0], an[1])) {
                            ok = false;
                            break;
                        }
                    }
                    if (ok ){
                        visited[row][i] = true;
                        //  System.out.println(i +":" + j);
                        ans.add(new int[]{row, i});
                        generateQueens(n, visited, ans, chosen, row+1);
                        ans.remove(ans.size()-1);
                        visited[row][i] = false;
                    }
                }
            }
        }
    }

    public boolean isValid(int x1, int y1, int x2, int y2){
        return (x1 != x2) && (y1 != y2) && (Math.abs(x1 - x2) != Math.abs(y1 - y2));
    }
}
