package com.company.superme198.BFS;

import com.company.superme198.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {


    /**Link:https://leetcode.com/problems/binary-tree-right-side-view/description/
     * Given a binary tree, imagine yourself standing on the right side of it,
     * return the values of the nodes you can see ordered from top to bottom.
     * Example:
     * Input: [1,2,3,null,5,null,4]
     * Output: [1, 3, 4]
     * Explanation:
     *    1            <---
     *  /   \
     * 2     3         <---
     *  \     \
     *   5     4       <---*/
    static List<Integer> rightSideView(TreeNode root) {
        if(root== null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
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
            ans.add(list.get(list.size()-1));//add all nodes that can't overlap by others.(rightmost node)
        }
        return ans;
    }

}
