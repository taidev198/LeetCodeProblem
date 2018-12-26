package com.company.superme198.BinarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by traig on 9:02 PM, 12/26/2018
 */
public class MedianOfTwoSortedArrays {
    /**Link:https://leetcode.com/problems/median-of-two-sorted-arrays/
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.
     *
     * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     *
     * You may assume nums1 and nums2 cannot be both empty.
     *
     * Example 1:
     *
     * nums1 = [1, 3]
     * nums2 = [2]
     *
     * The median is 2.0
     * Example 2:
     *
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     *
     * The median is (2 + 3)/2 = 2.5*/
    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if(len1 == 0){
            if(len2 % 2==0)
                return (double) (nums2[len2/2] + nums2[len2/2 -1])/2;
            return nums2[len2/2];
        }
        if(len2 == 0){
            if(len1 % 2==0)
                return (double) (nums1[len1/2] + nums1[len1/2 -1])/2;
            return nums1[len1/2];
        }

        List<Integer> res = new ArrayList<>();
        res.add(nums1[0]);
        for(int i=1; i< len1; i++){
            int l = 0, r = res.size() -1;
            while (l < r){
                int m = l + (r -l) /2;
                if (nums1[i] >= res.get(m))
                    r = m -1;
                else l = m +1;
            }
            if (res.get(l) <= nums1[i])
                res.add(l, nums1[i]);
            else res.add(l+1, nums1[i]);
        }
        for(int i=0; i< len2; i++){
            int l = 0, r = res.size() -1;
            while (l < r){
                int m = l + (r -l) /2;
                if (nums2[i] >= res.get(m))
                    r = m -1;
                else l = m +1;
            }
            if (res.get(l) <= nums2[i])
                res.add(l, nums2[i]);
            else res.add(l+1, nums2[i]);
        }
        System.out.println(res.get((len1+len2 )/2-1));
        System.out.println(res.get((len1+len2 )/2));
        if((len1 + len2) % 2==0){
            return (float)(res.get((len1+len2)/2) + res.get((len1+len2 )/2-1))/2;
        }
        return res.get((len1+len2)/2);
    }

    public static void main(String...args){
        System.out.println(findMedianSortedArrays(new int[]{1,2},new int[]{3,4} ));
    }


}
