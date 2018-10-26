package com.company.superme198.Tree;

import com.company.superme198.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BuildTreeFromInOrderAndPostOrder {

    /**Link:https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
     * Given inorder and postorder traversal of a tree, construct the binary tree.

     Note:
     You may assume that duplicates do not exist in the tree.

     For example, given

     inorder = [9,3,15,20,7]
     postorder = [9,15,7,20,3]
     Return the following binary tree:

     3
     / \
     9  20
     /  \
     15   7*/

    static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0)
            return null;
        if (postorder.length == 1)
            return new TreeNode(postorder[0]);
        List<Integer> list = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        int rootPosition = list.indexOf(postorder[postorder.length-1]);
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, rootPosition),
                Arrays.copyOfRange(postorder,0, rootPosition));
        root.right = buildTree(Arrays.copyOfRange(inorder, rootPosition + 1, inorder.length),
                Arrays.copyOfRange(postorder,rootPosition, postorder.length-1));
        return root;
    }
}
