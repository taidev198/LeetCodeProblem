package com.company.superme198.Math;

public class IsUglyNumber {
    /**Link:https://leetcode.com/problems/ugly-number/description/
     * Write a program to check whether a given number is an ugly number.
     * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
     * Example 1:
     * Input: 6
     * Output: true
     * Explanation: 6 = 2 × 3
     * */
    static  boolean isUgly(int num) {
        if(num == 1) return true;
        int[] factor = new int[]{2,3,5};
        if(num <=0 || num == Integer.MIN_VALUE)
            return false;
        int i = 2;
        while (num !=0 && i>=0){
            if (num % factor[i] == 0){
                num /= factor[i];
            }
            else i--;
        }
        return num ==1;
    }
}
