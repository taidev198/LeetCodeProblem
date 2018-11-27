package com.company.superme198.Math;

/**
 * Created by traig on 12:32 PM, 11/27/2018
 */
public class LargestTriangleArea {

    /**Link:https://leetcode.com/problems/largest-triangle-area/
     * You have a list of points in the plane. Return the area of the largest triangle that can be formed by any 3 of the points.
     *
     * Example:
     * Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
     * Output: 2
     * Explanation:
     * Notes:
     *
     * 3 <= points.length <= 50.
     * No points will be duplicated.
     *  -50 <= points[i][j] <= 50.
     * Answers within 10^-6 of the true value will be accepted as correct.*/
    static double largestTriangleArea(int[][] points) {
        double max = 0.0;
        for(int i=0; i< points.length -2; i++){
            for(int j = 0; j< points.length -1; j++){
                for(int k = 0; k< points.length; k++){
                    if(i != j && j != k && k != i){
                        max = Math.max(max, 0.5 *Math.abs((points[j][0] - points[i][0])
                                *(points[k][1] - points[i][1])
                                - (points[k][0] - points[i][0])
                                *(points[j][1] - points[i][1])));
                    }
                }
            }
        }

        return max;
    }
}
