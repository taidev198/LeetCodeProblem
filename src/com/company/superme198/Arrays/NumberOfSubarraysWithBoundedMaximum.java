package com.company.superme198.Arrays;

public class NumberOfSubarraysWithBoundedMaximum {


    /**Link:https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/description/
     * We are given an array A of positive integers, and two positive integers L and R (L <= R).
     * Return the number of (contiguous, non-empty) subarrays such that the value of the maximum array element in that subarray
     * is at least L and at most R.
     *
     * Example :
     * Input:
     * A = [2, 1, 4, 3]
     * L = 2
     * R = 3
     * Output: 3
     * Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
     * Note:
     *
     * L, R  and A[i] will be an integer in the range [0, 10^9].
     * The length of A will be in the range of [1, 50000].*/
    static int numSubarrayBoundedMax(int[] A, int L, int R) {
        int start =0, len = A.length, ans = 0;
        int max=A[0], lenSub=0;
        boolean[] visited = new boolean[len];
        for(int i =0; i< len; i++){
            max = Math.max(max, A[i]);
            lenSub++;
            if(A[i] >=L && A[i] <=R && !visited[i]){
                visited[i] = true;
                ans++;
            }
            if(max >=L && max <=R && lenSub >1 ){
                ans++;
                if (i == len -1){
                    i = start;
                    start++;
                    max=A[start];
                    lenSub=0;
                }
            }
            if(( max >R)  ){
                i = start;

                start++;
                max=A[start];
                lenSub=0;
            }

        }

        return ans;

    }

    public static void main(String...args){
        System.out.println(numSubarrayBoundedMax(new int[]{73,55,36,5,55,14,9,7,72,52}, 32, 69));
    }
}
