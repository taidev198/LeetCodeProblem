package com.company.superme198.Tree;

import com.company.superme198.TreeNode;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ConstructMaximumBinaryTree {
    /***Link:https://leetcode.com/problems/maximum-binary-tree/description/
     * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
     *
     * The root is the maximum number in the array.
     * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
     * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
     * Construct the maximum tree by the given array and output the root node of this tree.
     *
     * Example 1:
     * Input: [3,2,1,6,0,5]
     * Output: return the tree root node representing the following tree:
     *
     *       6
     *     /   \
     *    3     5
     *     \    /
     *      2  0
     *        \
     *         1*/
    static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0)
            return null;
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int max = Collections.max(list);
        int idxMax = list.indexOf(max);
        TreeNode root = new TreeNode(max);
        root.left=   constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, idxMax))   ;
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, idxMax+1, nums.length)) ;
        return root;
    }
}
