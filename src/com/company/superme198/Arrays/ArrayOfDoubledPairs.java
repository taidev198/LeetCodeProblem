package com.company.superme198.Arrays;

import java.util.Arrays;

/**
 * Created by traig on 10:05 AM, 12/9/2018
 */
public class ArrayOfDoubledPairs {


    static  boolean canReorderDoubled(int[] A) {
        int len = A.length;
        int numPairs = 0;
        boolean[] isSorted = new boolean[len];
        Arrays.sort(A);
        for (int i = 0; i < len; i++) {

            int left = i+1, right = len-1;
            while (left <=right){
                int mid = left + (right - left)/2;
                if(A[mid] == A[i]*2 && !isSorted[mid] && !isSorted[i] ){
                    isSorted[mid] = true;
                    isSorted[i] = true;
                    numPairs++;
                    break;
                }else if (A[mid] < A[i]*2){
                    right = mid-1;
                }else left = mid+1;
            }
//            for (int j = i+1; j < len; j++) {
//                if ((A[j] == A[i]*2 || A[i] == A[j]*2) && !isSorted[j] && !isSorted[i]){
//                    isSorted[j] = true;
//                    isSorted[i] = true;
//                    numPairs++;
//                    break;
//
//                }
//            }
        }
        System.out.println(Arrays.toString(isSorted));
        System.out.println(numPairs);
        return numPairs == len/2;
    }

    public static void main(String...args){
        System.out.println(canReorderDoubled(new int[]{7,-15,-15,23,-3,80,-35,40,68,22,44,98,20,0,-34,8,40,41,16,46,
                16,49,-6,-11,35,-15,-74,72,-8,60,40,-2,0,-6,34,14,-16,-92,54,14,-68,82,-30,50,22,25,16,70,-1,-96,11,45,54,40,92,-35,29,80,
                46,-30,27,7,-70,-37,41,-46,-98,1,-33,-24,-86,-70,80,-43,98,
                -49,30,0,27,2,82,36,0,-48,3,-100,58,32,90,-22,-50,-12,36,6,-3,-66,72,8,49,-30}));
    }
}
