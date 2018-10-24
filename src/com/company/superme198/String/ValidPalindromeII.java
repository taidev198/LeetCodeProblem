package com.company.superme198.String;

public class ValidPalindromeII {
    /***Link:https://leetcode.com/problems/valid-palindrome-ii/description/
     * Given a non-empty string s, you may delete at most one character.
     * Judge whether you can make it a palindrome.
     * Example 1:
     * Input: "aba"
     * Output: True
     * Example 2:
     * Input: "abca"
     * Output: True
     * Explanation: You could delete the character 'c'.*/
    static boolean validPalindrome(String s) {
        int left =0, right = s.length()-1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){

                if(s.charAt(left+1) == s.charAt(right) || s.charAt(left) == s.charAt(right-1)) {
                    if(isPalindrome(s, left+1, right) || isPalindrome(s,left, right-1))
                        return true;
                    return false;
                }
                else return false;

            } else{
                left++;
                right--;
            }
        }
        return true;
    }

    static boolean isPalindrome(String s, int l, int r){

        while (l<=r){
            if (s.charAt(l) == s.charAt(r)){
                r--;
                l++;
            }else return false;
        }
        return true;
    }

    public static void main(String...args){

        System.out.println(validPalindrome("eeccccbebaeeabebccceea"));
    }
}
