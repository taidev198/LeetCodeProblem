package com.company.superme198.Arrays;

public class CanPlaceflowers {


    /**Link:https://leetcode.com/problems/can-place-flowers/description/
     * Suppose you have a long flowerbed in which some of the plots are planted and some are not.
     * However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
     *
     * Given a flowerbed (represented as an array containing 0 and 1,where 0 means empty and 1 means not empty),
     * and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
     *
     * Example 1:
     * Input: flowerbed = [1,0,0,0,1], n = 1
     * Output: True
     * Example 2:
     * Input: flowerbed = [1,0,0,0,1], n = 2
     * Output: False*/
    static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int numOs ;
        if(n == 0) return true;
        int len = flowerbed.length;
        if(len == 1){
            return (n != 1 || flowerbed[0] == 0) && n <= len;
        }
        for(int i =0;i< len; i++){
            if(flowerbed[i] ==0 ){
                int j = i+1;//move to next place.
                numOs = 0;
                if(i ==0 && flowerbed[j] ==0){//can place at first but the next place must be empty.
                    n--;
                    numOs = -1;
                }
                while(j <len && flowerbed[j] == 0){
                    numOs++;
                    if(numOs == 1 && ((j +1 < flowerbed.length && flowerbed[j+1] == 0)
                            || (j ==len-1 && flowerbed[j] == 0))){//continue place until matching 1.
                        n --;
                        numOs = -1;
                    }
                    j++;
                }
                if (n <=0 )//if n is negative then can place .so return true.
                    return true;
                i=j-1;
            }
        }
        return false;
    }

    public static void main(String...args){

        System.out.println(canPlaceFlowers(new int[]{1,0,1,0,1,0,1},
        1));
    }
}
