package com.company.superme198.Stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by traig on 9:32 PM, 12/13/2018
 */
public class AsteroidCollision {


    /**Link:https://leetcode.com/problems/asteroid-collision/
     * We are given an array asteroids of integers representing asteroids in a row.
     *
     * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
     *
     * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
     *
     * Example 1:
     * Input:
     * asteroids = [5, 10, -5]
     * Output: [5, 10]
     * Explanation:
     * The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
     * Example 2:
     * Input:
     * asteroids = [8, -8]
     * Output: []
     * Explanation:
     * The 8 and -8 collide exploding each other.
     * Example 3:
     * Input:
     * asteroids = [10, 2, -5]
     * Output: [10]
     * Explanation:
     * The 2 and -5 collide resulting in -5.  The 10 and -5 collide resulting in 10.
     * Example 4:
     * Input:
     * asteroids = [-2, -1, 1, 2]
     * Output: [-2, -1, 1, 2]
     * Explanation:
     * The -2 and -1 are moving left, while the 1 and 2 are moving right.
     * Asteroids moving the same direction never meet, so no asteroids will meet each other.
     * Note:
     *
     * The length of asteroids will be at most 10000.
     * Each asteroid will be a non-zero integer in the range [-1000, 1000]..*/
    static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        int len = asteroids.length;
        int[] ans = new int[len];
        int i =0;
        stack.push(asteroids[i++]);
        while(i < len){
            if (stack.isEmpty())
                stack.push(asteroids[i]);
            else {
                int top = asteroids[i];
                while (!stack.isEmpty()){
                    if (stack.peek() >0 && top <0){
                        if(stack.peek() + top == 0)
                            stack.pop();
                        else if(Math.abs(stack.peek()) < Math.abs(top)){
                            stack.pop();
                            stack.push(top);
                        }
                    }
                    else {
                        stack.push(top);
                        break;
                    }
                    if (stack.size() > 1)
                    top = stack.pop();
                    else break;
                }
            }
            //after pushing new element onto stack.
            i++;

        }
        int j =len-1;
        while(!stack.isEmpty()){
            int tmp = stack.pop();
            if(stack.isEmpty() ){
                ans[j--] = tmp;
                break;
            }

            if(stack.peek() > 0 &&  tmp <0){
                if(stack.peek() + tmp == 0)
                    stack.pop();
                else  if(Math.abs(stack.peek()) < Math.abs(tmp)){
                    stack.pop();
                    stack.push(tmp);

                }
            }else ans[j--] = tmp;
        }
        return Arrays.copyOfRange(ans, j+1, len);
    }

    public static void main(String...args){
        System.out.println(Arrays.toString(asteroidCollision(new int[]{7,-1,2,-3,-6,-6,-6,4,10,2})));
    }
}
