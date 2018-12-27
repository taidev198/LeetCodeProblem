package com.company.superme198.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by traig on 5:46 PM, 12/27/2018
 */
public class CombinationSumII {
    /**Link:https://leetcode.com/problems/combination-sum-ii/
     * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
     *
     * Each number in candidates may only be used once in the combination.
     *
     * Note:
     *
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     * Example 1:
     *
     * Input: candidates = [10,1,2,7,6,1,5], target = 8,
     * A solution set is:
     * [
     *   [1, 7],
     *   [1, 2, 5],
     *   [2, 6],
     *   [1, 1, 6]
     * ]
     * Example 2:
     *
     * Input: candidates = [2,5,2,1,2], target = 5,
     * A solution set is:
     * [
     *   [1,2,2],
     *   [5]
     * ]*/
    static  List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];
        List<List<Integer>> ans = new ArrayList<>();
        return combinationIISumHelper(candidates, target, new ArrayList<>(), ans, visited);
    }

    static List<List<Integer>> combinationIISumHelper(int[] a, int sum, List<int[]> chosen,
                                                      List<List<Integer>> ans, boolean[] visited){
        if(sum ==0){
            List<Integer> temp  = new ArrayList<>();
            for (int[] ints : chosen) {
                temp.add(ints[0]);
            }
            boolean ok = true;
            for(int i=0; i< ans.size(); i++){
                if(ans.get(i).equals(temp)){
                    ok = false;
                    break;
                }
            }
            if(ok)
                ans.add(new ArrayList<>(temp));

        }else {
            for (int i  =0; i< a.length; i++) {
                if ((chosen.size() == 0
                        || (sum - a[i] >= 0 && chosen.get(chosen.size()-1)[1] <= i )) && !visited[i] ) {
                    chosen.add(new int[]{a[i], i});
                    visited[i] = true;
                    combinationIISumHelper(a, sum - a[i], chosen, ans, visited);
                    chosen.remove(chosen.size() - 1);//backtracking.
                    visited[i] = false;
                }
            }
        }
        return ans;
    }
}
