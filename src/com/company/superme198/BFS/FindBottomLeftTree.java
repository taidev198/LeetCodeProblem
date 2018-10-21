package com.company.superme198.BFS;

import com.company.superme198.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindBottomLeftTree {

    /**Link:https://leetcode.com/problems/find-bottom-left-tree-value/description/
     * Given a binary tree, find the leftmost value in the last row of the tree.
     * Example 1:
     * Input:
     *     2
     *    / \
     *   1   3
     * Output:
     * 1
     * Example 2:
     * Input:
     *         1
     *        / \
     *       2   3
     *      /   / \
     *     4   5   6
     *        /
     *       7
     * Output:
     * 7*/
    static  int findBottomLeftValue(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int ans = root.val;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            ans = ((LinkedList<TreeNode>) q).getFirst().val;
            for(int i=0;i<size;i++){
                TreeNode cur = q.poll();
                list.add(cur.val);
                if(cur.left != null){
                    q.add(cur.left);
                }
                if(cur.right != null){
                    q.add(cur.right);
                }
            }

        }
        return ans;
    }
}
