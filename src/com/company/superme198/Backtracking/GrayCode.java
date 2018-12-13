package com.company.superme198.Backtracking;

import java.util.*;

/**
 * Created by traig on 7:32 PM, 11/29/2018
 */
public class GrayCode {

    static List<Integer> grayCode(int n) {

        List<Integer> ans = new ArrayList<>();
        generateBinary(n, 0, ans, 0);
        return ans;
    }

    static void generateBinary(int n, Integer chosen, List<Integer> ans, int pow){
        if (pow == n ){
            ans.add(chosen);
        }

        else {
            for (int i = 0; i <=1 ; i++) {
                chosen += (int)Math.pow(2, pow) * i;
                generateBinary(n, chosen, ans, pow +1);
                chosen -= (int)Math.pow(2, pow) * i;
            }
        }
    }

    public static void main(String...args){

        System.out.println(grayCode(2));


    }
}
