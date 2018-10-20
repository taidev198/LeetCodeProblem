package com.company.superme198.BFS;

import com.company.superme198.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValueInEachRow {


    static List<Integer> largestValues(TreeNode root) {
        if(root== null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            int max = Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode cur = q.poll();
                list.add(cur.val);
                max = Math.max(max, cur.val);
                if(cur.left != null){
                    q.add(cur.left);
                }
                if(cur.right != null){
                    q.add(cur.right);
                }
            }
            ans.add(max);
        }
        return ans;
    }
}
