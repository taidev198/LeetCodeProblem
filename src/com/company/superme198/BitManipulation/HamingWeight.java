package com.company.superme198.BitManipulation;

/**
 * Created by traig on 9:18 PM, 12/2/2018
 */
public class HamingWeight {
    /**Link:https://leetcode.com/problems/number-of-1-bits/
     * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
     *
     * Example 1:
     *
     * Input: 11
     * Output: 3
     * Explanation: Integer 11 has binary representation 00000000000000000000000000001011
     * Example 2:
     *
     * Input: 128
     * Output: 1
     * Explanation: Integer 128 has binary representation 00000000000000000000000010000000*/
    static int hammingWeight(int n) {
        int ans = 0;
        for(int i =0; i< 32; i++){
            if((n & (1 << i)) != 0)//The number 1 << i is the number with 0 everywhere, except for a one in the ith position
                ans++;
        }
        return ans;
    }
}
