package com.company.superme198.HashTable;

import java.util.*;

/**
 * Created by traig on 8:53 AM, 11/19/2018
 */
public class DistributeCandies {

    /**Link:https://leetcode.com/problems/distribute-candies/
     * Given an integer array with even length, where different numbers in this array represent different kinds of candies.
     * Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister.
     * Return the maximum number of kinds of candies the sister could gain.
     * Example 1:
     * Input: candies = [1,1,2,2,3,3]
     * Output: 3
     * Explanation:
     * There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
     * Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
     * The sister has three different kinds of candies.
     * Example 2:
     * Input: candies = [1,1,2,3]
     * Output: 2
     * Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
     * The sister has two different kinds of candies, the brother has only one kind of candies. */
    //solution using hashtable:126ms
    static int distributeCandies(int[] candies) {
        int len = candies.length;
        Hashtable<Integer, Integer> res = new Hashtable<>();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (!res.containsKey(candies[i]))
                res.put(candies[i], 1);
            else {
                int value =  res.get(candies[i]);
                res.replace(candies[i], value, value+1);
            }
        }
        List<Integer> tmp = new ArrayList<>(res.values());
        if(tmp.size() <= len /2)
            return tmp.size();
        return len/2;
    }
    //using hashset: 77ms
    static int distributeCandies1(int[] candies) {
        int len = candies.length;
        HashSet<Integer> res = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            res.add(candies[i]);
        }
        if(res.size() <= len /2)
            return res.size();
        return len/2;
    }

    public static void main(String...args){
        System.out.println(distributeCandies(new int[]{1,1, 2,3, 2,2}));
    }
}
