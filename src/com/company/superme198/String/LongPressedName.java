package com.company.superme198.String;

public class LongPressedName {

    /**
     * Link:https://leetcode.com/contest/weekly-contest-107/problems/long-pressed-name/
     * Your friend is typing his name into a keyboard.  Sometimes, when typing a character c,
     * the key might get long pressed, and the character will be typed 1 or more times.
     * You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name,
     * with some characters (possibly none) being long pressed.
     * Example 1:
     * Input: name = "alex", typed = "aaleex"
     * Output: true
     * Explanation: 'a' and 'e' in 'alex' were long pressed.
     * Example 2:
     * Input: name = "saeed", typed = "ssaaedd"
     * Output: false
     * Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.*/
    static boolean isLongPressedName(String name, String typed) {

        int lenName = name.length();
        int lenTyped = typed.length();
        if (lenName > lenTyped)
            return false;
        int i = 0, j = 0;
        while (i < lenName && j < lenTyped) {
            int k = i + 1;
            if (name.charAt(i) != typed.charAt(j))
                return false;
            while (k < lenName && name.charAt(i) == name.charAt(k))
                k++;
            int l = j + 1;
            while (l < lenTyped && typed.charAt(j) == typed.charAt(l))
                l++;
            if ((k - i) > (l - j))
                return false;
            i = k - 1;
            j = l - 1;
            i++;
            j++;

        }


        return i == lenName && j == lenTyped;

    }

    public static void main(String...args){

        System.out.println(isLongPressedName("pyplrz", "ppyypllr"));
    }
}
