package com.company.superme198.Backtracking;

import java.util.*;

/**
 * Created by traig on 3:04 PM, 12/30/2018
 */
public class SubSetsII {
    /**Link:https://leetcode.com/problems/subsets-ii/
     * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
     *
     * Note: The solution set must not contain duplicate subsets.
     *
     * Example:
     *
     * Input: [1,2,2]
     * Output:
     * [
     *   [2],
     *   [1],
     *   [1,2,2],
     *   [2,2],
     *   [1,2],
     *   []
     * ]*/
    static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        int len = nums.length;

        for(int i=0; i<= len ;i++){
            subsetsWithDupHelper(nums, i, new ArrayList<>(), ans);
        }
        return new ArrayList<>(ans);
    }


    static void subsetsWithDupHelper(int[] a, int k, List<int[]> chosen, Set<List<Integer>> ans){
        if(k==0){
            List<Integer> temp  = new ArrayList<>();
            for (int[] ints : chosen) {
                temp.add(ints[0]);
            }
            ans.add(new ArrayList<>(temp));

        }else {
            for (int i  =0; i< a.length; i++) {
                if (chosen.size() == 0  || (chosen.get(chosen.size()-1)[1] < i ) ) {
                    chosen.add(new int[]{a[i], i});
                    subsetsWithDupHelper(a, k-1, chosen, ans);
                    chosen.remove(chosen.size() - 1);//backtracking.
                }
            }
        }
    }
}
