package com.company.superme198.BitManipulation;

/**
 * Created by traig on 9:31 AM, 12/5/2018
 */
public class BinaryNumberWithAlternatingBits {

    /**Link:https://leetcode.com/problems/binary-number-with-alternating-bits/
     * Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.
     *
     * Example 1:
     * Input: 5
     * Output: True
     * Explanation:
     * The binary representation of 5 is: 101
     * Example 2:
     * Input: 7
     * Output: False
     * Explanation:
     * The binary representation of 7 is: 111.
     * Example 3:
     * Input: 11
     * Output: False
     * Explanation:
     * The binary representation of 11 is: 1011.*/
    static boolean hasAlternatingBits(int n) {
        int pre = -1;
        while(n != 0){
            if(pre == -1){
                pre = n&1;
            }else if((n&1) == pre)
                return false;
            pre =n &1;
            n= n>>1;
        }
        return true;
    }
}
