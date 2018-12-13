package com.company.superme198.HashTable;

import java.util.*;

/**
 * Created by traig on 8:15 AM, 11/19/2018
 */
public class LongestHarmoniousSubsequences {


    static int findLHS(int[] nums) {
        int maxLen = 0;
        int len = nums.length;

        for(int i= 0; i< len; i++){
            int startMem = nums[i];
            int j =i+1;
            int min = startMem;
            int max = startMem;
            int lenSub = 1;
            while(j < len){

                if(nums[j] <= min && Math.abs(max - nums[j])   >1){
                    j++;
                    continue;
                }

                if(nums[j] >= max && Math.abs(nums[j] - min ) >1){
                    j++;
                    continue;
                }
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                lenSub++;
                j++;
            }
            if (max - min == 1)
            maxLen = Math.max(lenSub, maxLen);
        }

        return maxLen;
    }


    static int findLHS1(int[] nums){
        int len = nums.length;
        int maxLen = 0;
        Hashtable<Integer, Integer> res = new Hashtable<>();
        for (int i = 0; i <nums.length ; i++) {
            int less = 0;
            int greater = 0;
            int equal =0;
            if (!res.containsKey(nums[i])){
                equal++;
                int j =i+1;
                while (j < len){
                    if (nums[j] == nums[i])
                        equal++;
                    else if (Math.abs(nums[j] - nums[i]) == 1 && nums[j] > nums[i])
                        greater++;
                    else if (Math.abs(nums[j] - nums[i]) == 1 && nums[j] < nums[i])less++;
                        j++;
                }
                if (less ==0 && greater == 0)
                    continue;
                maxLen = Math.max(Math.max(equal+less, maxLen), equal+ greater);
                res.put(nums[i], maxLen);
            }
        }
        return maxLen;
    }

    static int findLHS2(int[] nums) {
        int len = nums.length;
        int maxLen = 0;
        HashMap<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (!res.containsKey(nums[i]))
                res.put(nums[i], 1);
            else {
                int value = res.get(nums[i]);
                res.replace(nums[i], value, value+1);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(res.entrySet());
        for (int i = 0; i <list.size() -1 ; i++) {
            int key = list.get(i).getKey();
            int value = list.get(i).getValue();
            int key1 = list.get(i+1).getKey();
            int value1 = list.get(i+1).getValue();
            if (Math.abs(key - key1) == 1){
                maxLen = Math.max(value + value1, maxLen);
            }
        }
        return maxLen;
    }
    public static void main(String...args){
        System.out.println(findLHS1(new int[]{0,3,1,3,3,3,0,1,0,2,0,3,1,3,-3,2,0,3,1,2,2,-3,2,2,3,3}));


    }
}
