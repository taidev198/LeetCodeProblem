package com.company.superme198.String;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by traig on 9:45 AM, 12/9/2018
 */
public class VerifyingAnAlienDictionary {


    /**953. Verifying an Alien Dictionary
     * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order.
     *  The order of the alphabet is some permutation of lowercase letters.

     Given a sequence of words written in the alien language, and the order of the alphabet,
     return true if and only if the given words are sorted lexicographicaly in this alien language.



     Example 1:

     Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
     Output: true
     Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
     Example 2:

     Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
     Output: false
     Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
     Example 3:

     Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
     Output: false
     Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '*/
    static boolean isAlienSorted(String[] words, String order) {
        String[] clone = Arrays.copyOf(words, words.length);
        List<String> list = Arrays.asList(words);
        list.sort((o1, o2) -> {
            char[] charo1 = o1.toCharArray();
            char[] charo2 = o2.toCharArray();
            int k = 0;
            int l = 0;
            while (k < charo1.length && l < charo2.length && charo1[k] == charo2[l]) {
                k++;
                l++;
            }
            if (k == charo1.length && l == charo2.length)
                return 0;
            if (k == charo1.length || l == charo2.length){
                return charo1.length - charo2.length;
            }

            return order.indexOf(charo1[k]) - order.indexOf(charo2[l]);
        });

        return Arrays.equals(clone, words);

    }

    public static void main(String...args){
        System.out.println(isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
    }
}
