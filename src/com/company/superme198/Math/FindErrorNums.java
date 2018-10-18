package com.company.superme198.Math;

import java.util.Arrays;

public class FindErrorNums {


    /**Link:https://leetcode.com/problems/set-mismatch/description/
     * Beat 57%
     * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error,
     * one of the numbers in the set got duplicated to another number in the set,
     * which results in repetition of one number and loss of another number.
     * Given an array nums representing the data status of this set after the error.
     * Your task is to firstly find the number occurs twice and then find the number that is missing.
     * Return them in the form of an array.
     * Example 1:
     * Input: nums = [1,2,2,4]
     * Output: [2,3]
     * Note:
     * The given array size will in the range [2, 10000].
     * The given array's numbers won't have any order.*/
    static int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        int len = nums.length;
        int sum = (len *(len +1)) /2;
        boolean[] isDuplicate = new boolean[len+1];
        for(int i =1; i<= len ;i++){
            if(isDuplicate[nums[i-1]]){
                ans[0] =nums[i-1];
            }else{
                isDuplicate[nums[i-1]] = true;
                sum -= nums[i-1];
            }
        }
        ans[1] = sum;
        return ans;
    }

    public static void main(String...args){

        System.out.println(Arrays.toString(findErrorNums(new int[]{8,7,3,5,3,6,1,4})));
    }
}
