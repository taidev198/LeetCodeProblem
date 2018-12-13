package com.company.superme198.TwoPointers;

public class TrappingRainWater {

    static int trap(int[] height) {
        int ans =0, len = height.length;
        int left = 0, right ;
        while(left < len){
            if (height[left] == 0){
                left++;
                continue;
            }

            right =left+1;
            while(right < len && height[left] > height[right])
                right++;
            if(right - left == 1)
                continue;
            int temp = height[left];
            while(left < right)
                ans += (temp - height[left++]);

        }
        return ans;
    }

    public static void main(String...args){

        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
