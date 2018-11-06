package com.company.superme198.Tree;

import com.company.superme198.TreeNode;

import java.util.Stack;

public class LowestCommonAncestorOfABinarySearchTree {

    /***Link:https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
     * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
     *
     * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
     *
     * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
     *
     *         _______6______
     *        /              \
     *     ___2__          ___8__
     *    /      \        /      \
     *    0      _4       7       9
     *          /  \
     *          3   5
     * Example 1:
     *
     * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * Output: 6
     * Explanation: The LCA of nodes 2 and 8 is 6.
     * Example 2:
     *
     * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     * Output: 2
     * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself
     *              according to the LCA definition.
     */

    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(hasNode(p, q))//if p is ancestor of q and itself, return p
            return p;
        if(hasNode(q,p))
            return q;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();

            if(cur.left != null && cur.right != null){//find node is ancestor of p and q if one has left subtree has p , etc.
                if((hasNode(cur.left, p) && hasNode(cur.right, q)) || (hasNode(cur.left, q) && hasNode(cur.right, p)))
                    return cur;
            }
            if(cur.left != null)
                stack.push(cur.left);
            if(cur.right != null)
                stack.push(cur.right);

        }

        return root;
    }

    static boolean hasNode(TreeNode root, TreeNode searchedNode){
        if(root == null)
            return false;
        if(root.val == searchedNode.val)
            return true;
        // if(root.val > searchedNode.val)
        return  hasNode(root.left, searchedNode)
                ||  hasNode(root.right, searchedNode);
    }
}
