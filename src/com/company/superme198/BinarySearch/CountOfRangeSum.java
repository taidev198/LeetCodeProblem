package com.company.superme198.BinarySearch;

/**
 * Created by traig on 6:41 PM, 11/18/2018
 */
public class CountOfRangeSum {

    static int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length;
        long[] prefixSum = new long[len+1];
        int ans =0;
        for(int i=1; i<= len; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
            if((nums[i-1]) <= upper && (nums[i-1]) >= lower)
                ans++;
        }
        int j =0;
        while(j < len){
          //  System.out.println(prefixSum[len] - prefixSum[j]);
            if((prefixSum[len] - prefixSum[j]) > upper )
                len --;
            else if( (prefixSum[len] - prefixSum[j]) < lower)
                j++;
            else{
                j++;
                len --;
                ans++;
            }

        }

        return ans;
    }

    public static void main(String...args){
        System.out.println(countRangeSum(new int[]{-2,5,-1}, -2, 2));
    }
}
