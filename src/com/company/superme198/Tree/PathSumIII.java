package com.company.superme198.Tree;

import com.company.superme198.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSumIII {

    static int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        int ans = 0 ;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode cur = s.pop();

                List<List<Integer>> chosen = new ArrayList<>();
                pathSumHelper(cur, sum, new ArrayList<>(), chosen);
                ans += chosen.size();


            if(cur.right != null)
                s.push(cur.right);
            if(cur.left != null)
                s.push(cur.left);
        }


        return ans;
    }

    static int travel(TreeNode root, int sum, int s){
        if(root == null || s > sum)
            return 0;
        if(sum == s)
            return 1;
        int left = travel(root.left, sum, s+root.val);
        int right = travel(root.right, sum , s+root.val);
        return left + right;


    }

    static void pathSumHelper(TreeNode root, int sum, List<Integer> list,
                              List<List<Integer>> ans){
        if(root != null){

            list.add(root.val);
            if( sum == root.val){//if node is leaf and node's is equal sum
                ans.add(new ArrayList(list));//add list to ans
                System.out.println(ans);
            }
            pathSumHelper(root.left, sum- root.val,list, ans);
            pathSumHelper(root.right, sum - root.val, list, ans);

            list.remove(list.size()-1);//backtracking.
        }
    }
    public static void main(String...args){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(-1);


        root.right = new TreeNode(-3);
        root.right.left = new TreeNode(-2);
        System.out.println(pathSum(root, -2));


    }
}
