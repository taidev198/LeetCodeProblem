package com.company.superme198.Tree;

import com.company.superme198.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsSubTree {

    /**Link:https://leetcode.com/problems/subtree-of-another-tree/description/
     * Given tree s:
     *
     *      3
     *     / \
     *    4   5
     *   / \
     *  1   2
     * Given tree t:
     *    4
     *   / \
     *  1   2
     * Return true, because t has the same structure and node values with a subtree of s.*/
    boolean isSubtree(TreeNode t1, TreeNode t2) {
        if(t2 == null) return true;
        if(t1 == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(t1);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode cur = q.poll();
                if(cur.val==t2.val && isSameTree(cur, t2))return true;
                if(cur.left != null){
                    q.add(cur.left);
                }
                if(cur.right != null){
                    q.add(cur.right);
                }
            }
        }

        return false;
    }

    public boolean isSameTree(TreeNode q, TreeNode p){
        if(q == null || p == null)
            return q == null && p == null;
        return q.val==p.val && isSameTree(q.left, p.left) && isSameTree(q.right, p.right);
    }
}
