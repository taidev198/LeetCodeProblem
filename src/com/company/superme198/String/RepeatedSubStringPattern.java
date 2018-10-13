package com.company.superme198.String;

public class RepeatedSubStringPattern {


    /**Link:https://leetcode.com/problems/repeated-substring-pattern/description/
     * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
     * You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
     *Example 1:
     *Input: "abab"
     *Output: True
     *Explanation: It's the substring "ab" twice.
     * Example 2:
     * Input: "aba"
     * Output: False*/
    static  boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i< len/2 ;i++){
            temp.append(s.charAt(i));
            boolean isValid = true;
            for(int j= i+1; j < len -i  ;j+=(i+1)){
                if(!temp.toString().equals(s.substring(j, j + i+1))){
                    isValid = false;
                    break;
                }
            }
            if(isValid && (len - i -1) % (i+1) == 0)
                return true;
        }

        return false;
    }

    public static void main(String...args){

        repeatedSubstringPattern("aaa");
    }
}
