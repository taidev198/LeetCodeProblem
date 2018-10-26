package com.company.superme198.Tree;

import com.company.superme198.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowToTree {

    /**Link:https://leetcode.com/problems/add-one-row-to-tree/description/
     * Given the root of a binary tree, then value v and depth d,
     * you need to add a row of nodes with value v at the given depth d. The root node is at depth 1.
     *
     * The adding rule is: given a positive integer depth d,
     * for each NOT null tree nodes N in depth d-1, create two tree nodes with value v as N's left subtree root and right subtree root. And N's original left subtree should be the left subtree of the new left subtree root, its original right subtree should be the right subtree of the new right subtree root. If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as the new root of the whole original tree, and the original tree is the new root's left subtree.
     *
     * Example 1:
     * Input:
     * A binary tree as following:
     *        4
     *      /   \
     *     2     6
     *    / \   /
     *   3   1 5
     *
     * v = 1
     *
     * d = 2
     *
     * Output:
     *        4
     *       / \
     *      1   1
     *     /     \
     *    2       6
     *   / \     /
     *  3   1   5
     * */
    static TreeNode addOneRow(TreeNode root, int v, int d) {
        if(root == null)
            return root;
        if(d ==0){
            root.left =new TreeNode(v);
            root.right =new TreeNode(v);
            return root;
        }
        if(d ==1){
            TreeNode fakeRoot = new TreeNode(v);
            fakeRoot.left = root;
            return fakeRoot;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        d--;
        while(d != 1){
            int size = q.size();

            for(int i=0;i<size;i++){
                TreeNode cur = q.poll();
                if (cur == null) continue;

                if(cur.left != null){
                    q.add(cur.left);
                    System.out.print(cur.left.val);
                }
                if(cur.right != null){
                    q.add(cur.right);
                    System.out.print(cur.right.val);
                }
            }
            d--;
        }
        System.out.println("size:" + q.size());
        for(int i =0; i<q.size(); i++){
            TreeNode cur = q.poll();
            TreeNode leftNode = new TreeNode(v);
            TreeNode rightNode = new TreeNode(v);
            if(cur != null){
                System.out.print(cur.val);
                leftNode.left= cur.left ;
                cur.left = leftNode;
                rightNode.right =  cur.right ;
                cur.right = rightNode;
            }

        }
        return root;
    }

    public static void main(String...args){

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.right=new TreeNode(1);
        root.left.left = new TreeNode(3);

        root.right.left = new TreeNode(5);
        addOneRow(root, 1, 3);
    }
}
