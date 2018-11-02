package com.company.superme198.HashTable;

public class CheckSubArraySumK {

    /**Link:https://leetcode.com/problems/continuous-subarray-sum/description/
     * Given a list of non-negative numbers and a target integer k, write a function to check
     * if the array has a continuous subarray of size at least 2 that sums up to the multiple of k, that is,
     * sums up to n*k where n is also an integer.
     *
     * Example 1:
     * Input: [23, 2, 4, 6, 7],  k=6
     * Output: True
     * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
     * Example 2:
     * Input: [23, 2, 6, 4, 7],  k=6
     * Output: True
     * Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.*/
    static boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        if(len <=1 )
            return false;
        int[] prefix = new int[len+1];
        for(int i =1;i <=len ; i++)
            prefix[i] = prefix[i-1] + nums[i-1];

        for(int i =0;i< len-1 ;i++){
            int right = len;
            while(right - i >1){
                if( prefix[right] - prefix[i] == k || (k != 0 && (prefix[right] - prefix[i]) % k == 0))
                    return true;
                right--;
            }
        }

        return false;
    }

    public static void main(String...args){
        System.out.println(checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));

    }
}
