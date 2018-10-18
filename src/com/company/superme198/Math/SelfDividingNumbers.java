package com.company.superme198.Math;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    /**Link:https://leetcode.com/problems/self-dividing-numbers/description/
     * A self-dividing number is a number that is divisible by every digit it contains.
     * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
     * Also, a self-dividing number is not allowed to contain the digit zero.
     * Given a lower and upper number bound, output a list of every possible self dividing number,
     * including the bounds if possible.
     * Example 1:
     * Input:
     * left = 1, right = 22
     * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
     * */
    static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for(int i = left ; i<= right; i++){
            if(i % 10==0)
                continue;
            int j = i;
            boolean isValid = true;
            while(j != 0){
                if(  j % 10 == 0 ||i % (j%10) != 0 ){
                    isValid = false;
                    break;
                }
                j /= 10;
            }
            if(!isValid)
                continue;
            ans.add(i);
        }
        return ans;
    }

    public static void main(String...args){
        System.out.println(selfDividingNumbers(100,10000));
    }
}
