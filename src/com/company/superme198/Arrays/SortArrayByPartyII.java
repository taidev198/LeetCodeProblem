package com.company.superme198.Arrays;

import java.util.Arrays;

public class SortArrayByPartyII {


    /**Link:
     * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
     * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
     * You may return any answer array that satisfies this condition.
     * Example 1:
     * Input: [4,2,5,7]
     * Output: [4,5,2,7]
     * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.*/
    static int[] sortArrayByParityII(int[] A) {
        int len = A.length;
        boolean isOdd = false;
        for(int i = 0; i< len -1 ;i++){
            int j = i+1;
            if(i % 2 ==0 ){
                if(A[i] % 2 == 0)
                    continue;
                isOdd = true;
            }
            else {
                if(A[i] % 2 == 1)
                    continue;
                isOdd = false;
            }
            while(j < len-1){
                if(!isOdd && A[j] % 2 == 0)
                    j++;
                else if(isOdd && A[j] % 2 != 0)
                    j++;
                else break;
            }
            A[i] += A[j];
            A[j ] = A[i] - A[j];
            A[i] -= A[j];

        }
        return A;

    }

    public static void main(String...args){
        System.out.println(1 - 1.1);
        System.out.println(Arrays.toString(sortArrayByParityII(new int[]{4, 2, 5, 7})));
    }

}
