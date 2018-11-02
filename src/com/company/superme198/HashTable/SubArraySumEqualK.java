package com.company.superme198.HashTable;

public class SubArraySumEqualK {

    /**Link:https://leetcode.com/problems/subarray-sum-equals-k/description/
     * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
     *
     * Example 1:
     * Input:nums = [1,1,1], k = 2
     * Output: 2
     * Note:
     * The length of the array is in range [1, 20,000].
     * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].*/
    static int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] prefix = new int[len+1];
        for(int i =1;i <=len ; i++)
            prefix[i] = prefix[i-1] + nums[i-1];
        int ans = 0;
        for(int i = 0; i <len ;i++){
            int right = len;
            while(right >= i ){
                if( prefix[right] - prefix[i] == k){
                    ans++;
                }
                right--;
            }
        }
        return ans;
    }

    public static void main(String...args){

        System.out.println(subarraySum(new int[]{0,0,0,0,0,0,0,0,0,0}, 0));
    }
}
