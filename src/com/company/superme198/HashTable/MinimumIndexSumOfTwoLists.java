package com.company.superme198.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by traig on 4:39 PM, 11/19/2018
 */
public class MinimumIndexSumOfTwoLists {


    /**Link:https://leetcode.com/problems/minimum-index-sum-of-two-lists/
     * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.
     *
     * You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers,
     * output all of them with no order requirement. You could assume there always exists an answer.
     *
     * Example 1:
     * Input:
     * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
     * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
     * Output: ["Shogun"]
     * Explanation: The only restaurant they both like is "Shogun".
     * Example 2:
     * Input:
     * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
     * ["KFC", "Shogun", "Burger King"]
     * Output: ["Shogun"]
     * Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
     * Note:
     * The length of both lists will be in the range of [1, 1000].
     * The length of strings in both lists will be in the range of [1, 30].
     * The index is starting from 0 to the list length minus 1.
     * No duplicates in both lists
     *
     * Runtime: 75 ms, faster than 11.18% of Java online submissions for Minimum Index Sum of Two Lists..*/
    static String[] findRestaurant(String[] list1, String[] list2) {
        List<String> list11 = Arrays.asList(list1);
        List<String> list22 = Arrays.asList(list2);
        String[] ans = new String[list11.size() + list2.length];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <list11.size() ; i++) {
            if (list22.indexOf(list1[i]) != -1)
                min = Math.min(min, i +list22.indexOf(list1[i]));
        }
        System.out.println(min);
        int j =0;
        for (int i = 0; i < list22.size(); i++) {
            if ((list11.indexOf(list2[i]) + i) == min &&  list11.indexOf(list2[i]) != -1)
                ans[j++] = list2[i];
        }
        return Arrays.copyOfRange(ans, 0 , j);
    }

    public static void main(String...args){
        System.out.println(Arrays.toString(findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"KFC", "Burger King", "Tapioca Express", "Shogun"})));
    }
}
