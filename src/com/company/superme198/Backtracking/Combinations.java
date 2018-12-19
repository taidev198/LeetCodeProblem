package com.company.superme198.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {


    /**Link:https://leetcode.com/problems/combinations/
     * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
     *
     * Example:
     *
     * Input: n = 4, k = 2
     * Output:
     * [
     *   [2,4],
     *   [3,4],
     *   [2,3],
     *   [1,2],
     *   [1,3],
     *   [1,4],
     * ]*/
    static List<List<Integer>> combine(int n, int k) {

        boolean[] visited = new boolean[n+1];
        List<List<Integer>> ans = new ArrayList<>();
        combineHelper(n, k, ans, new ArrayList<>(), visited);
        return ans;

    }

    static void combineHelper(int n, int k, List<List<Integer>> ans, List<Integer> chosen, boolean[] visited){
        if(chosen.size() == k){
            ans.add(new ArrayList(chosen));
        }else{
            for(int i =1; i <= n ;i++){
                if(chosen.size() ==0  || chosen.get(chosen.size()-1 ) < i){
                    visited[i] = true;
                    chosen.add(i);
                    combineHelper(n, k, ans, chosen, visited);
                    visited[i] = false;
                    chosen.remove(chosen.size() -1);

                }
            }
        }
    }

    public static void main(String...args){

        System.out.println(combine(5,4));
    }
}
