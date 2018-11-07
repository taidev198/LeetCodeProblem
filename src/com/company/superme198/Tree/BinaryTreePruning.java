package com.company.superme198.Tree;

import com.company.superme198.TreeNode;

public class BinaryTreePruning {

    /**Link:https://leetcode.com/problems/binary-tree-pruning/description/
     * We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.
     *
     * Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
     *
     * (Recall that the subtree of a node X is X, plus every node that is a descendant of X.)
     *
     * Example 1:
     * Input: [1,null,0,0,1]
     * Output: [1,null,0,null,1]
     *
     * Explanation:
     * Only the red nodes satisfy the property "every subtree not containing a 1".
     * The diagram on the right represents the answer.*/
    static TreeNode pruneTree(TreeNode root) {

        postOrder(root);
        return root;
    }

    static boolean postOrder(TreeNode root){
        if(root ==null)
            return true;
        if(root.val == 0 && root.left == null && root.right ==null)//if leaf is 0, return false
            return false;//remove from leaf.
        boolean left = postOrder(root.left);
        boolean right = postOrder(root.right);

        if(!left)
            root.left = null;
        if(!right)
            root.right = null;
        return root.val != 0 || root.left != null || root.right != null;//check if leaf is 0, return false,
        //otherwise return true;

    }
}
