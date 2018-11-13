package com.company.superme198.HashTable;

import java.util.*;

public class FindAllAnagramsInAString {


    /**LInk:https://leetcode.com/problems/find-all-anagrams-in-a-string/
     * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
     *
     * Strings consists of lowercase English letters only and the length of both strings s and p
     * will not be larger than 20,100.
     *
     * The order of output does not matter.
     *
     * Example 1:
     *
     * Input:
     * s: "cbaebabacd" p: "abc"
     *
     * Output:
     * [0, 6]
     *
     * Explanation:
     * The substring with start index = 0 is "cba", which is an anagram of "abc".
     * The substring with start index = 6 is "bac", which is an anagram of "abc".
     * Example 2:
     *
     * Input:
     * s: "abab" p: "ab"
     *
     * Output:
     * [0, 1, 2]
     *
     * Explanation:
     * The substring with start index = 0 is "ab", which is an anagram of "ab".
     * The substring with start index = 1 is "ba", which is an anagram of "ab".
     * The substring with start index = 2 is "ab", which is an anagram of "ab".*/
    static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] counting = new int[26];
        for (int i = 0; i <p.length() ; i++) {
            char ch = p.charAt(i);
            counting[ch-'a']++;
        }
        int[] clone =counting.clone();
        int[] zero = new int[26];
        for (int i = 0; i <= s.length() - p.length(); i++) {
            char ch = s.charAt(i);
            if (clone[ch - 'a'] != 0) {
                int j = i;
                while (j  < p.length() + i) {
                        ch = s.charAt(j);
                        if (clone[ch - 'a'] ==1)
                            clone[ch - 'a'] = 0;
                        else if (clone[ch - 'a'] ==0)
                            break;
                        else clone[ch - 'a']--;
                        if (Arrays.equals(clone, zero)){
                            ans.add(i);
                            break;
                        }
                    j++;

                }
                clone = counting.clone();
            }
        }
        return ans;
    }


    public static void main(String...args){


        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }


}
