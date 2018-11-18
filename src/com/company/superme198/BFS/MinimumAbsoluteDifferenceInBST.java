package com.company.superme198.BFS;

import com.company.superme198.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by traig on 3:57 PM, 11/18/2018
 */
public class MinimumAbsoluteDifferenceInBST {

    /**Link:https://leetcode.com/problems/minimum-absolute-difference-in-bst/
     * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
     *
     * Example:
     *
     * Input:
     *
     *    1
     *     \
     *      3
     *     /
     *    2
     *
     * Output:
     * 1
     *
     * Explanation:
     * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).*/
    static  int getMinimumDifference(TreeNode root) {
        List<Integer> chosen = new ArrayList<>();
        inorder(root, chosen);
        int min = Integer.MAX_VALUE;
        for(int i=1; i< chosen.size();i ++){
            min = Math.min(min, Math.abs(chosen.get(i) - chosen.get(i-1)));
        }

        return min;
    }
    static  void inorder(TreeNode root, List<Integer> chosen){
        if(root != null){
            inorder(root.left, chosen);
            chosen.add(root.val);
            inorder(root.right, chosen);
        }
    }

    public  static void main(String...args){

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.right=new TreeNode(1);
        root.left.left = new TreeNode(3);

        root.right.left = new TreeNode(5);
        System.out.println(getMinimumDifference(root));
    }
}
