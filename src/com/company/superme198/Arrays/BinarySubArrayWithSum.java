package com.company.superme198.Arrays;

public class BinarySubArrayWithSum {

    /**In an array A of 0s and 1s, how many non-empty subarrays have sum S?
     Example 1:
     Input: A = [1,0,1,0,1], S = 2
     Output: 4
     Explanation:
     The 4 subarrays are bolded below:
     [1,0,1,0,1]
     [1,0,1,0,1]
     [1,0,1,0,1]
     [1,0,1,0,1]*/
    static  int numSubarraysWithSum(int[] A, int S) {
        int ans = 0;
        int start =0;
        int sum = 0;
        for(int i =0; i< A.length; i++){
            sum += A[i];
            if(sum == S){
                ans++;
                int j =i+1;
                while(j < A.length && A[j] == 0){
                    ans++;
                    j++;
                }
                sum =0;
                i = start;
                start++;
            }else if(sum > S){
                sum =0;
                i = start;
                start++;
            }
        }
        return ans;
    }
}
