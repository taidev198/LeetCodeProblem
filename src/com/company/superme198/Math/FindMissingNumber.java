package com.company.superme198.Math;

public class FindMissingNumber {

    /**Link:https://leetcode.com/problems/missing-number/description/
     * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
     * Example 1:
     * Input: [3,0,1]
     * Output: 2
     * Example 2:
     *
     * Input: [9,6,4,2,3,5,7,0,1]
     * Output: 8
     * Note:
     * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
     */
    static  int missingNumber(int[] nums) {
        int sum = (nums.length +1)*(nums.length) /2;
        for(int i=0;i<nums.length;i++)
            sum -= nums[i];
        return sum;

    }
}
