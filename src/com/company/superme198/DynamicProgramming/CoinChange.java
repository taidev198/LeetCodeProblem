package com.company.superme198.DynamicProgramming;

import java.util.Arrays;

public class CoinChange {

    static int coinChange(int[] coins, int amount) {
        int len = coins.length;
        Arrays.sort(coins);
        int cnt = 0;
        for(int i = len -1;i>=0;i--){
            if( coins[i] <= amount){
                cnt +=  amount / coins[i];
                amount -= ((amount / coins[i]) * coins[i]);
                if(amount == 0) break;
            }
        }
        if(amount != 0)
            return -1;
        return cnt;
    }

    public static void main(String...args) {

        System.out.println(coinChange(new int[]{186,419,83,408}, 6249));
    }
}
