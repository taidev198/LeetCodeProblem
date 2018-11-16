package com.company.superme198.TwoPointers;

import java.util.List;

/**
 * Created by traig on 4:24 PM, 11/16/2018
 */
public class LongestWordInDictionaryThroughDeleting {

    /**Link:https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
     * Given a string and a string dictionary, find the longest string in the dictionary that can be formed
     * by deleting some characters of the given string. If there are more than one possible results,
     * return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
     *
     * Example 1:
     * Input:
     * s = "abpcplea", d = ["ale","apple","monkey","plea"]
     *
     * Output:
     * "apple"
     * Example 2:
     * Input:
     * s = "abpcplea", d = ["a","b","c"]
     *
     * Output:
     * "a"*/
    static  String findLongestWord(String s, List<String> d) {
        int len = s.length();
        String ans = "";
        for(int i = 0; i< d.size(); i++){
            String tmp = d.get(i);
            if(isSub(s, tmp)){
                if(tmp.length() > ans.length()
                        ||  (tmp.length() == ans.length() && tmp.compareTo(ans) <0))
                    ans = tmp;
            }
        }
        return ans;
    }

    static boolean isSub(String s, String t){
        int lenS = s.length(), lenT = t.length();
        int start =0;
        for(int i=0; i< lenS; i++){
            if(s.charAt(i) == t.charAt(start))
                start++;
            if(start == lenT)
                return true;
        }

        return false;
    }
}
