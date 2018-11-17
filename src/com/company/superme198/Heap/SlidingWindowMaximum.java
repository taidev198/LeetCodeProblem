package com.company.superme198.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by traig on 6:47 AM, 11/14/2018
 */
public class SlidingWindowMaximum {


    /**Link:https://leetcode.com/problems/sliding-window-maximum/
     * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
     * You can only see the k numbers in the window. Each time the sliding window moves right by one position.\
     * Return the max sliding window.
     *
     * Example:
     *
     * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
     * Output: [3,3,5,5,6,7]
     * Explanation:
     *
     * Window position                Max
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7*/

    //Using priorityQueue
    static  int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if(len == 0) return new int[0];
        int[] ans = new int[len -k +1];
        int idx =0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(len -k +1, (o1, o2) -> -o1.compareTo(o2));
        for(int i =0; i< k; i++){
            queue.add(nums[i]);
        }
        ans[idx ++] = queue.peek();
        for(int i =k; i< len; i++){
            queue.remove(nums[i-k]);
            queue.add(nums[i]);
            ans[idx ++] = queue.peek();
        }
        return ans;
    }
    public static void main(String...args){
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3)));
    }
}
