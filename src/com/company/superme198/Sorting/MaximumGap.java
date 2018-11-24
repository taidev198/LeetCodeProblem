package com.company.superme198.Sorting;

import java.util.PriorityQueue;

/**
 * Created by traig on 7:09 PM, 11/24/2018
 */
public class MaximumGap {

    /**Link:https://leetcode.com/problems/maximum-gap/
     * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
     *
     * Return 0 if the array contains less than 2 elements.
     *
     * Example 1:
     *
     * Input: [3,6,9,1]
     * Output: 3
     * Explanation: The sorted form of the array is [1,3,6,9], either
     *              (3,6) or (6,9) has the maximum difference 3.
     * Example 2:
     *
     * Input: [10]
     * Output: 0
     * Explanation: The array contains less than 2 elements, therefore return 0.
     * Note:
     *
     * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
     * Try to solve it in linear time/space.*/
    static int maximumGap(int[] nums) {
        int len =nums.length;
        if(len <2) return 0;
        int ans =0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i< len ;i++)
            queue.add(nums[i]);

        ans = Math.abs(queue.poll() - queue.peek());
        while(!queue.isEmpty()){
            if(queue.size()>1)
                ans =Math.max(Math.abs(queue.poll() - queue.peek()), ans);
            else break;
        }

        return ans;
    }
}
