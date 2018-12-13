package com.company.superme198.HashTable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by traig on 10:50 PM, 12/12/2018
 */
public class IntersectionOfTwoArrays {

    static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> ans = new HashSet<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i =0, j =0;
        while(i < len1 && nums1[i] != nums2[j]){
            i++;
        }

        while(i < len1 && j <len2 && nums1[i] == nums2[j]){
            ans.add(nums1[i]);
            i++;
            j++;
        }
//
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String...args){


        System.out.println(Arrays.toString(intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}
