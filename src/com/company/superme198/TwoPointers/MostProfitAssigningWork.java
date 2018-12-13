package com.company.superme198.TwoPointers;

import java.util.Arrays;

/**
 * Created by traig on 1:01 PM, 11/17/2018
 */
public class MostProfitAssigningWork {

    static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);
        int minAbility = worker[0];
        int right = difficulty.length -1;
        int left , start =0;
        int ans =0;
        for(int i=0; i< right; i++){
            left = start;
            while(left < right){
                if(difficulty[left] <= worker[i] &&
                        ((left >=1 && profit[left- 1] < profit[left] ) || left == 0))
                    left++;
                else break;
            }
            if (difficulty[left] <= worker[i] || (left >0 &&difficulty[left-1] <= worker[i]))
            ans+= left > 0?profit[left-1]: profit[0];
            start = left;
        }

        return ans;
    }

    public static void main(String...args){
        System.out.println(maxProfitAssignment(new int[]{85,47,57}, new int[]{24,66,99},
                new int[]{40,25,25}));
    }
}
