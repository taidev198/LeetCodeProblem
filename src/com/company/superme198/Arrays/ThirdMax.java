package com.company.superme198.Arrays;

/**
 * Created by traig on 8:18 PM, 11/25/2018
 */
public class ThirdMax {

    static int thirdMax(int[] nums) {
        int len = nums.length;
        if(len == 1)
            return nums[0];
        if(len == 2)
            return Math.max(nums[0], nums[1]);

        int max = nums[0], secMax = nums[0], thirdMax = Integer.MIN_VALUE;

        for (int i = 1; i < len; i++) {
            if (nums[i] >= max){
                max = nums[i];
                secMax = Math.min(secMax, nums[i]);
            }else {
                if(nums[i] >= secMax)
                    secMax =  nums[i];
                else thirdMax  = Math.max(nums[i], thirdMax);

            }
        }
        if(max == secMax)
            return max;

        return thirdMax;
    }

    public static void main(String...args){
        StringBuilder tmp = new StringBuilder();
        System.out.println(thirdMax(new int[]{2, 2, 3, 4}));
    }
}
