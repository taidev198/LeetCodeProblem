package com.company.superme198.HashTable;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by traig on 10:47 AM, 11/13/2018
 */
public class UncommonWordsFromTwoSentences {


    /**Link:https://leetcode.com/problems/uncommon-words-from-two-sentences/
     * We are given two sentences A and B.  (A sentence is a string of space separated words.
     * Each word consists only of lowercase letters.)
     *
     * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
     *
     * Return a list of all uncommon words.
     *
     * You may return the list in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: A = "this apple is sweet", B = "this apple is sour"
     * Output: ["sweet","sour"]
     * Example 2:
     *
     * Input: A = "apple apple", B = "banana"
     * Output: ["banana"]*/
    static  String[] uncommonFromSentences(String A, String B) {

        String[] strA = A.split(" ");
        String[] strB = B.split(" ");
        Hashtable<String, Integer> ans = new Hashtable<>();

        for (int i = 0; i < strA.length; i++) {
            if (!ans.containsKey(strA[i]))
                ans.put(strA[i], 1);
            else {
                int value = ans.get(strA[i]);
                ans.replace(strA[i], value, value+1);
            }
        }

        for (int i = 0; i < strB.length; i++) {
            if (!ans.containsKey(strB[i]))
                ans.put(strB[i], 1);
            else {
                int value = ans.get(strB[i]);
                ans.replace(strB[i], value, value+1);
            }
        }

        String[] res  = new String[strA.length + strB.length];
        List<Map.Entry<String, Integer>> temp = new ArrayList<>(ans.entrySet());
    int k =0;
        for (Map.Entry<String, Integer> entry :
               temp ) {
            if (entry.getValue() == 0)
                res[k++] = entry.getKey();
        }


        return Arrays.copyOfRange(res, 0 ,k);

    }

}
