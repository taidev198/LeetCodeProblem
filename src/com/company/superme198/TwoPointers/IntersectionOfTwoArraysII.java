package com.company.superme198.TwoPointers;

import java.util.Arrays;

/**
 * Created by traig on 6:04 PM, 11/16/2018
 */
public class IntersectionOfTwoArraysII {

    static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length){
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int len1 = nums1.length, len2 = nums2.length;
        if(len1== 0 || len2 == 0)
            return new int[0];

        int[] ans = new int[len1];
        int idx =0;
        int i=0, j=0;
        while(i < len1  && nums1[i] != nums2[j]){
            i++;
        }

        while(i < len1 && j < len2 && nums1[i] == nums2[j]){
            ans[idx++] = nums1[i];
            i++;
            j++;
        }

        return Arrays.copyOfRange(ans, 0, idx);
    }

    public static void main(String...arg){

        System.out.println(Arrays.toString(intersect(new int[]{4, 9 ,5}, new int[]{9,4,9,8,4})));

    }
}
