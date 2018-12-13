package com.company.superme198.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindAllDuplicatesInArray {

    static List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i <n ; i++) {
            ans.add(0);
        }
        for (int i = 0; i <n ; i++) {
                ans.set(nums[i]-1, ans.get(nums[i]-1) +1);
        }
        int num =0;
        ans.removeAll(Collections.singleton(0));
//        for (int i = 0; i < n; i++) {
//            if (ans.get(i) == -1){
//                ans.remove(nums[i]-1);
//            }
//        }
        return ans;
    }

    public static void main(String...args){

        System.out.println(findDuplicates(new int[]{1,2,3,3,4,4}));

    }
}
