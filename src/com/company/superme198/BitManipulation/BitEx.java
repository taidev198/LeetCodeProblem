package com.company.superme198.BitManipulation;

/**
 * Created by traig on 9:10 PM, 12/2/2018
 */
public class BitEx {

    static int hammingWeight(int n) {
        int ans = 0;
        for(int i =0; i< 32; i++){
            if((n & (1 << i)) != 0)
                ans++;
        }
        return ans;
    }

    public static void main(String...args){
        System.out.println(hammingWeight(11));
        System.out.println(3^26);

    }
}
