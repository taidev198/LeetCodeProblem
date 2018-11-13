package com.company.superme198.HashTable;

import java.util.Arrays;

/**
 * Created by traig on 5:58 AM, 11/14/2018
 */
public class PermutationInString {


    /**Link:https://leetcode.com/problems/permutation-in-string/
     * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
     * In other words, one of the first string's permutations is the substring of the second string.
     Example 1:
     Input:s1 = "ab" s2 = "eidbaooo"
     Output:True
     Explanation: s2 contains one permutation of s1 ("ba").
     Example 2:
     Input:s1= "ab" s2 = "eidboaoo"
     Output: False
     Note:
     The input strings only contain lower case letters.
     The length of both given strings is in range [1, 10,000].*/
    static boolean checkInclusion(String s1, String s2) {
        int[] counting = new int[26];
        for (int i = 0; i <s1.length() ; i++) {
            char ch = s1.charAt(i);
            counting[ch-'a']++;
        }
        int[] clone =counting.clone();
        int[] zero = new int[26];
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            char ch = s2.charAt(i);
            if (clone[ch - 'a'] != 0) {
                int j = i;
                while (j  < s1.length() + i) {
                    ch = s2.charAt(j);
                    if (clone[ch - 'a'] ==1)
                        clone[ch - 'a'] = 0;
                    else if (clone[ch - 'a'] ==0)
                        break;
                    else clone[ch - 'a']--;
                    if (Arrays.equals(clone, zero)){
                        return true;
                    }
                    j++;

                }
                clone = counting.clone();
            }
        }

        return false;
    }
}
