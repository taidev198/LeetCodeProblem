package com.company.superme198.Arrays;

import java.util.Arrays;

public class ShorestUnsortedContinuousSubArray {

    /**Link:https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
     * Given an integer array, you need to find one continuous subarray that if you only sort
     * this subarray in ascending order, then the whole array will be sorted in ascending order, too.
     *
     * You need to find the shortest such subarray and output its length.
     *
     * Example 1:
     * Input: [2, 6, 4, 8, 10, 9, 15]
     * Output: 5
     * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make
     * the whole array sorted in ascending order.
     * Note:
     * Then length of the input array is in range [1, 10,000].
     * The input array may contain duplicates, so ascending order here means <=.*/
    static int findUnsortedSubarray(int[] nums) {
        int[] temp = nums.clone();//clone original array.
        Arrays.sort(temp);//sort clone array to make target.
        int len = nums.length;
        int ans =0;
        for(int i =0; i< len; i++){
            if(nums[i] != temp[i]){//find the numbers of different elements
                int j = len -1;//between two arrays.
                while(j > i && temp[j] == nums[j])
                    j--;
                ans = j - i+1;
                break;
            }
        }
        return ans;
    }
}
