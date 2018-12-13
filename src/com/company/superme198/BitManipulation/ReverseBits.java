package com.company.superme198.BitManipulation;

/**
 * Created by traig on 8:42 PM, 12/3/2018
 */
public class ReverseBits {

    static int reverseBits(int n) {
        for(int i = 0; i<16; i++){
            int temp1 = 1 <<i;
            int temp2 = 1<< (31-i);
            if((temp1 & n) == (temp2 & n))
                continue;
            if((temp1 & n) == 1){
                n = n | temp2;
            }else{
                n = n & temp2;
            }
            if((temp2 & n) == 1){
                n = n | temp1;
            }else{
                n = n & temp1;
            }
        }
        return n;
    }

    public static void main(String...args){

        System.out.println(reverseBits(5));
    }
}
