package com.company.superme198.Tree;

import com.company.superme198.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BuildTreeFromPreOrderAndInOrder {
    /***Link:https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     *
     * Note:
     * You may assume that duplicates do not exist in the tree.
     *
     * For example, given
     *
     * preorder = [3,9,20,15,7]
     * inorder = [9,3,15,20,7]
     * Return the following binary tree:
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * */
    static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        if (preorder.length == 1)
            return new TreeNode(preorder[0]);
        List<Integer> list = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        int rootPosition = list.indexOf(preorder[0]);
        TreeNode root = new TreeNode(preorder[0]);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1+rootPosition),
                Arrays.copyOfRange(inorder,0, rootPosition));
        root.right = buildTree(Arrays.copyOfRange(preorder, rootPosition + 1, preorder.length),
                Arrays.copyOfRange(inorder,rootPosition+1, inorder.length));
        return root;
    }

}
