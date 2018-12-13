package com.company.superme198.BinarySearchTree;

import java.math.BigInteger;

/**
 * Created by traig on 6:18 PM, 11/17/2018
 */
public class ContainsDuplicateIII {

    static  boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int left =0,right=0;
        int n = nums.length;
        while(left <n){
            right =left+1;

            while(right <n ){
                long temp = nums[right] - nums[left];
                long temp1 = Math.abs( nums[right] - nums[left] );
                if (temp <Integer.MIN_VALUE && temp > Integer.MAX_VALUE
                        &&  temp1 <Integer.MIN_VALUE && temp1 > Integer.MAX_VALUE )
                    right++;
                if(  temp<= t && temp1<= t){

                    if(right -left <= k) return true;
                }
                right++;
            }
            left++;

        }
        return false;
    }

    public static void main(String...args){
        System.out.println(containsNearbyAlmostDuplicate(new int[]{-1,2147483647}, 1, 2147483647));



    }
}
