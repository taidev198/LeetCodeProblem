package com.company.superme198.Tree;

import com.company.superme198.TreeNode;

import java.util.Stack;

public class TrimTree {

    /**Link:https://leetcode.com/problems/trim-a-binary-search-tree/description/
     * Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.
     *
     * Example 1:
     * Input:
     *     1
     *    / \
     *   0   2
     *
     *   L = 1
     *   R = 2
     *
     * Output:
     *     1
     *       \
     *        2
     * Example 2:
     * Input:
     *     3
     *    / \
     *   0   4
     *    \
     *     2
     *    /
     *   1
     *
     *   L = 1
     *   R = 3
     *
     * Output:
     *       3
     *      /
     *    2
     *   /
     *  1*/
    static TreeNode trimBST(TreeNode root, int L, int R) {

        if(root == null)
            return root;
        TreeNode ans  = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            ans = insertIntoBST(ans, cur.val);
            if(cur.left != null)
                stack.push(cur.left);
            if(cur.right != null)
                stack.push(cur.right);
        }
        return ans;

    }

    static  TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode tmp = root;
        if (root == null) return new TreeNode(val);
        boolean isLeft = false;
        TreeNode cur = root;
        while (tmp != null ){
            if (tmp.val > val){
                isLeft = true;
                cur = tmp;
                tmp = tmp.left;
            }
            else{
                cur = tmp;
                tmp = tmp.right;
                isLeft = false;
            }
        }
        if (isLeft) cur.left = new TreeNode(val);
        else cur.right = new TreeNode(val);

        return root;
    }


}
