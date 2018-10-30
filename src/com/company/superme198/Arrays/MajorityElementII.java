package com.company.superme198.Arrays;

import java.util.*;

public class MajorityElementII {


    /**Link:https://leetcode.com/problems/majority-element-ii/description/
     * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

     Note: The algorithm should run in linear time and in O(1) space.

     Example 1:

     Input: [3,2,3]
     Output: [3]
     Example 2:

     Input: [1,1,1,3,3,2,2,2]
     Output: [1,2]*/
    static  List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans=  new ArrayList<>();
        int n = nums.length;
        if( n== 1){
            ans.add(nums[0]);
            return ans;
        }
        if (n==2){
            if (nums[1] == nums[0]) {
                ans.add(nums[1]);
            } else {
                ans.add(nums[1]);
                ans.add(nums[0]);
                return ans;
            }
        }
        for(int i=0; i< nums.length; i++){
            if (!map.containsKey(nums[i]))
                map.put(nums[i], 1);
            else {
                Integer tmp = map.get(nums[i]);
                if (tmp*3 + 3> n && !ans.contains(nums[i]))
                    ans.add(nums[i]);
                map.replace(nums[i], tmp, tmp+1);
            }
        }

        return  ans;
    }

    public static void main(String...args){
        System.out.println(majorityElement(new int[]{1,2}));
    }
}
