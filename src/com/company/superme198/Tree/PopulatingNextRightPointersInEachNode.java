package com.company.superme198.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    /**Link:https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
     * Given a binary tree

     struct TreeLinkNode {
     TreeLinkNode *left;
     TreeLinkNode *right;
     TreeLinkNode *next;
     }
     Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

     Initially, all next pointers are set to NULL.

     Note:

     You may only use constant extra space.
     Recursive approach is fine, implicit stack space does not count as extra space for this problem.
     You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
     Example:

     Given the following perfect binary tree,

     1
     /  \
     2    3
     / \  / \
     4  5  6  7
     After calling your function, the tree should look like:

     1 -> NULL
     /  \
     2 -> 3 -> NULL
     / \  / \
     4->5->6->7 -> NULL*/

    static   class TreeLinkNode {
     int val;
     TreeLinkNode left, right, next;
     TreeLinkNode(int x) { val = x; }
        }
    static void connect(TreeLinkNode root) {
        if(root == null || (root.left == null && root.right == null))
            return;

        Queue<TreeLinkNode> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            int size= queue.size();
            TreeLinkNode temp = queue.peek();
            for(int i=0; i< size; i++){
                TreeLinkNode cur = queue.poll();
                if(i == 0)
                    temp = cur;
                else{
                    temp.next = cur;
                    temp = cur;
                }

                if(cur.left != null)
                    queue.add(cur.left);
                if(cur.right != null)
                    queue.add(cur.right);
            }

        }

    }

}
