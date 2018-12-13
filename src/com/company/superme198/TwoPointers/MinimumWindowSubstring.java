package com.company.superme198.TwoPointers;

import java.util.Arrays;

/**
 * Created by traig on 8:09 AM, 11/15/2018
 */
public class MinimumWindowSubstring {


    static String minWindow(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();

        int[] counting = new int[26];
        for (int i = 0; i <t.length() ; i++) {
            char ch = t.charAt(i);
            counting[ch-'A']++;
        }
        String minLen =s;
        int[] clone = counting.clone();
        int[] zero = new int[26];
        for(int i=0; i < lenS; i++){
            if(clone[s.charAt(i) - 'A'] != 0){
                int j = i;
                while (j  < lenS ) {
                   char ch = s.charAt(j);
                    if (clone[ch - 'A'] ==1)
                        clone[ch - 'A'] = 0;
                    else if (clone[ch - 'A'] ==0)
                        break;
                    else clone[ch - 'A']--;
                    if (Arrays.equals(clone, zero)){
                       if (minLen.length() > (j -i + 1))
                           minLen = s.substring(i, j+1);
                        break;
                    }
                    j++;

                }
                clone = counting.clone();
            }
        }
        return minLen;
    }

    public static void main(String...args){

        System.out.println(minWindow("ADOBECODEBANC ","ABC"));

    }
}
