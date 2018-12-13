package com.company.superme198.Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class ThirdMaximum {

    static int thirdMax(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        if(len <3){
            return Collections.max(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }
        int secondMax = nums[1], thirdMax = nums[2];
        if (secondMax < thirdMax){
            thirdMax += secondMax;
            secondMax = thirdMax - secondMax;
            thirdMax -= secondMax;
        } if (max < secondMax){
            max += secondMax;
            secondMax = max - secondMax;
            max -= secondMax;
        }
            if (thirdMax == secondMax)
                thirdMax  = Integer.MIN_VALUE;
        for (int i = 3; i < len; i++) {
            if (nums[i] >= max){
                max = nums[i];
            }else {
                if (nums[i] >= secondMax){
                    secondMax = nums[i];
                    continue;
                }
                if (nums[i] > thirdMax)
                    thirdMax= nums[i];
            }
        }

     return thirdMax == Integer.MIN_VALUE? max: thirdMax;
    }

    public static void main(String...args){
        System.out.println(thirdMax(new int[]{2, 2, 2, 1}));
    }
}
