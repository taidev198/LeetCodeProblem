package com.company.superme198.Arrays;

import java.util.Arrays;

public class RemoveTriple {

    /**Link:https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
     * Given a sorted array nums, remove the duplicates in-place such that
     *  duplicates appeared at most twice and return the new length.
     Do not allocate extra space for another array, you must do this by
     modifying the input array in-place with O(1) extra memory.
     Example 1:

     Given nums = [1,1,1,2,2,3],

     Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

     It doesn't matter what you leave beyond the returned length.
     Example 2:

     Given nums = [0,0,1,1,1,1,2,3,3],

     Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.

     It doesn't matter what values are set beyond the returned length.*/
    static  int removeDuplicates(int[] nums) {
        int left =0, right=left;
        int n= nums.length;
        int k=0;
        while (right < n ){
            if (nums[left] == nums[right]) right++;
            else {
                if(right -left >=2){
                    nums[k++] = nums[left];
                    nums[k++] = nums[left];
                }
                else if (right-left == 1){
                    nums[k++] = nums[left];

                }
                left =right;
            }
        }
        if(right -left >=2){
            nums[k++] = nums[left];
            nums[k++] = nums[left];
        }
        else if (right-left == 1){
            nums[k++] = nums[left];

        }
        System.out.println(Arrays.toString(nums));
        return k;
    }

    public static void main(String...args){
        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
    }
}
