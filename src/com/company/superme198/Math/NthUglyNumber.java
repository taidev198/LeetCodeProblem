package com.company.superme198.Math;

public class NthUglyNumber {

    static int nthUglyNumber(int n) {

        if( n <=6)
            return n;
        n -=6;
        int j = 8;
        while(n != 0){
            if(isUgly(j)){
                n--;
            }
            j++;
        }
        return j-1;
    }

    static boolean isUgly(int num) {
        if(num == 1) return true;

        if(num <=0 || num == Integer.MIN_VALUE)
            return false;
        int[] factor = new int[]{2,3,5};
        int i = 2;
        while (num !=0 && i>=0){
            if (num % factor[i] == 0){
                num /= factor[i];
            }
            else i--;
        }
        return num ==1;
    }

    public static void main(String...args){

        System.out.println(nthUglyNumber(433));

    }

}
