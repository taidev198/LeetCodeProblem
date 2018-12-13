package com.company.superme198.TwoPointers;

/**
 * Created by traig on 6:22 PM, 11/16/2018
 */
public class SubarrayProductLessThanK {

    static int numSubarrayProductLessThanK(int[] nums, int k) {
        int len =1;
        int start =0, ans =0, s =1;
        for(int i= 0; start< nums.length; i++){
            len++;
            s *= nums[i];
            if (s >=k ||i == nums.length -1 ){
                if (s < k)
                    ans++;
                len =0;
                s =1;
                i = start;
                start++;
            }
            else {
                ans++;
                len++;

            }
        }
        return ans;

    }


    public static void main(String...args){

        System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }
}
