package com.company.superme198.HashTable;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class IsSequence {


    static boolean isSubsequence(String s, String t) {

        Map<Character, Integer> map = new Hashtable<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), i);
        }


        return true;
    }

    public static void main(String...args){
        Map<Character, Integer> map = new LinkedHashMap<>();
        map.put('a', 1);
        map.put('a', 2);
        System.out.println(map.toString());

    }
}
