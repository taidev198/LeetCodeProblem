package com.company.superme198.Arrays;

/**
 * Created by traig on 7:07 PM, 11/18/2018
 */
public class ValidMoutainArray {

    static boolean validMountainArray(int[] A) {
        int len = A.length;
        if(len <3) return false;
        int l = 0, r = len -1;
            while(l < r-1 && A[l] < A[l+1])
                l++;
            while(l < r && A[r] < A[r-1])
                r--;
        return l == r && l > 0 && r < len;
    }


    public static void main(String...args){
        System.out.println(validMountainArray(new int[]{0,3,2,1}));
    }
}
