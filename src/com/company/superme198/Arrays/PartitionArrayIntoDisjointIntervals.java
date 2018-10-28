package com.company.superme198.Arrays;

public class PartitionArrayIntoDisjointIntervals {


    /**Link:https://leetcode.com/problems/partition-array-into-disjoint-intervals/description/
     * Given an array A, partition it into two (contiguous) subarrays left and right so that:
    * Every element in left is less than or equal to every element in right.
    * left and right are non-empty.
    * left has the smallest possible size.
    * Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.
    * Example 1:
    * Input: [5,0,3,8,6]
    * Output: 3
    * Explanation: left = [5,0,3], right = [8,6]
    * Example 2:

    * Input: [1,1,1,0,6,12]
    * Output: 4
    * Explanation: left = [1,1,1,0], right = [6,12]*/
    static int partitionDisjoint(int[] A){
        int len = A.length;
        int ans =1;
        int maxLeft = A[0];
        int minRight ;
        for (int i = 1; i < len; i++) {
            //find minRight
            int j =i;
            minRight = A[i];
            while(j < len)
                minRight = Math.min(minRight, A[j++]);
            if (maxLeft <= minRight)
                break;
            else {
                maxLeft = Math.max(maxLeft, A[i]);
                ans++;

            }
        }
        return ans;
    }

    public static void main(String...args){
        System.out.println(partitionDisjoint(new  int[]{1,1,1,0,6,12}));
    }
}
