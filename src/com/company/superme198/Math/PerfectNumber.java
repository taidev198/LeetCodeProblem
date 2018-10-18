package com.company.superme198.Math;

public class PerfectNumber {
    /**We define the Perfect Number is
     * a positive integer that is equal to the sum of all its positive divisors except itself.
     * Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
     * Example:
     * Input: 28
     * Output: True
     * Explanation: 28 = 1 + 2 + 4 + 7 + 14*/
    static boolean checkPerfectNumber(int num) {
        int s=1,k=(int)Math.sqrt(num);
        for(int i = 2;i<= k;i++){
            if(num % i ==0 )
                s += (i + num/i);
        }
        if(k *k == num)
            s += k;
        return s == num;
    }
}
