package com.company.superme198.Arrays;

public class SumMinSubArrays {

    static int sumSubarrayMins(int[] A) {
        int start =0, len = A.length, ans = 0;
        int min=A[0],lenSub =0;
        boolean[] visited = new boolean[len];
        for(int i =0; i< len; i++){
            min = Math.min(min, A[i]);
            lenSub++;
            if( !visited[i]){
                visited[i] = true;
                ans = ans % 1000000007 + A[i] %1000000007;
            }
            if (lenSub >1)
            ans = ans % 1000000007 + min %1000000007;
            if( i== len-1 ){
                i = start;
                start++;
                if(start < len)
                    min=A[start];
                lenSub=0;
            }

        }
        return ans;
    }

    public static void main(String...args){


        System.out.println(sumSubarrayMins(new int[]{3,1,2,4}));
    }
}
