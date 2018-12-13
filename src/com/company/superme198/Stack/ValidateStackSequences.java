package com.company.superme198.Stack;

import java.util.Stack;

/**
 * Created by traig on 5:43 PM, 12/13/2018
 */
public class ValidateStackSequences {
    /**Link:https://leetcode.com/problems/validate-stack-sequences/
     * Given two sequences pushed and popped with distinct values, return true if and only if this could have been the result of a sequence of push
     * and pop operations on an initially empty stack.
     *
     *
     *
     * Example 1:
     *
     * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
     * Output: true
     * Explanation: We might do the following sequence:
     * push(1), push(2), push(3), push(4), pop() -> 4,
     * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
     * Example 2:
     *
     * Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
     * Output: false
     * Explanation: 1 cannot be popped before 2.*/
    static boolean validateStackSequences(int[] pushed, int[] popped) {
        int i =0, j =0;
        if(pushed.length ==0) return true;
        Stack<Integer> stack = new Stack<>();
        stack.push(pushed[i++]);
        while(!stack.isEmpty() || i < popped.length){
            if(stack.isEmpty() || stack.peek() != popped[j]  ){
                stack.push(pushed[i++]);
            } else {
                j++;
                stack.pop();
            }
            if(i == pushed.length && !stack.isEmpty() && stack.peek() != popped[j] ||
                    (j == popped.length && !stack.isEmpty()))
                return false;

        }

        return true;

    }

    public static void main(String...args){
        System.out.println(validateStackSequences(new int[]{4, 0, 1, 2, 3}, new int[]{4, 2, 3, 0, 1}));
    }
}
