package com.company.superme198.HashTable;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by traig on 10:14 PM, 11/12/2018
 */
public class LongestPalindrome {

    /**Link:https://leetcode.com/problems/longest-palindrome/
     * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
     *
     * This is case sensitive, for example "Aa" is not considered a palindrome here.
     *
     * Note:
     * Assume the length of given string will not exceed 1,010.
     *
     * Example:
     *
     * Input:
     * "abccccdd"
     *
     * Output:
     * 7
     *
     * Explanation:
     * One longest palindrome that can be built is "dccaccd", whose length is 7.*/
    static int longestPalindrome(String s) {

        int ans =0;
        int n = s.length();
        Hashtable<Character, Integer> hashtable = new Hashtable<>();
        for (int i = 0; i <n ; i++) {
            char ch = s.charAt(i);
            if(!hashtable.containsKey(ch))
                hashtable.put(ch, 1);
            else {
                int value = hashtable.get(ch);
                hashtable.replace(ch, value, value+1);
            }
        }
       Enumeration<Integer> e = hashtable.elements();
       List<Integer> list = Collections.list(e);
        Collections.sort(list);
        boolean hasOdd = false;
        for (int i = list.size() -1; i >=0 ; i--) {
            if(list.get(i) % 2 == 1)
                hasOdd = true;
            ans += list.get(i) - list.get(i) % 2;

        }
        if(hasOdd)//if has odd , plus 1.
            return ans +1 ;
        return ans;
    }

    public static void main(String...args){
        System.out.println(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }

}
