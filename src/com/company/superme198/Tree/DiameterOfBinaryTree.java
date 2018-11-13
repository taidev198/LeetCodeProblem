package com.company.superme198.Tree;

import com.company.superme198.TreeNode;

public class DiameterOfBinaryTree {

    /**Link:https://leetcode.com/problems/diameter-of-binary-tree/description/
     *
     * Given a binary tree, you need to compute the length of the diameter of the tree.
     * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
     * This path may or may not pass through the root.
     *
     * Example:
     * Given a binary tree
     *           1
     *          / \
     *         2   3
     *        / \
     *       4   5
     * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
     *
     * Note: The length of path between two nodes is represented by the number of edges between them.*/

    static int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        int max = maxDepth(root.left) + maxDepth(root.right);
        max =Math.max( Math.max( diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)), max);

        return max ;
    }
    static int maxDepth(TreeNode root){//find depth of each root
        if(root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}