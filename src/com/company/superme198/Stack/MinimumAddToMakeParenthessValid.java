package com.company.superme198.Stack;

import java.util.Stack;

public class MinimumAddToMakeParenthessValid {

    /**Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions )
     * so that the resulting parentheses string is valid.
     * Formally, a parentheses string is valid if and only if:
     * It is the empty string, or
     * It can be written as AB (A concatenated with B), where A and B are valid strings, or
     * It can be written as (A), where A is a valid string.
     * Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.*/
    static int minAddToMakeValid(String S) {
        int len = S.length();
        if(len == 0) return 0;
        int min = 0;
        Stack<Character> stack = new Stack<>();
        char[] charArray = S.toCharArray();
        for(int i=0; i< len; i++){
            if(charArray[i] == '(')
                stack.push(charArray[i]);
            else {
                if(stack.isEmpty())
                    min++;
                else stack.pop();
            }
        }
        return min + stack.size();

    }

    public static void main(String...args){
        System.out.println(minAddToMakeValid("()))(("));

    }
}
