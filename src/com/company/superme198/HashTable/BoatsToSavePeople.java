package com.company.superme198.HashTable;

import java.util.Arrays;

/**
 * Created by traig on 6:23 AM, 11/14/2018
 */
public class BoatsToSavePeople {

    static int numRescueBoats(int[] people, int limit) {
        int ans =0, len = people.length, h = 0;
        Arrays.sort(people);
        for(int i=0; i< len ;i++){
            h += people[i];
            if(h >= limit){
                if (h > limit){
                    i--;
                }
                h =0;
                ans++;
            }else if (i == len -1 && h < limit)
                ans++;
        }
        if(h >= limit){
            ans++;
        }
        return ans;
    }

    public static void main(String...args){
        System.out.println(numRescueBoats(new int[]{5,2,1,4}, 6));

    }
}
