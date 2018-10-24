package com.company.superme198.Tree;

import com.company.superme198.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TwoSumIV {

    /**Link:https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
     * Given a Binary Search Tree and a target number
     * , return true if there exist two elements in the BST such that their sum is equal to the given target.
     Example 1:
     Input:
     5
     / \
     3   6
     / \   \
     2   4   7
     Target = 9
     Output: True

     Example 2:
     Input:
     5
     / \
     3   6
     / \   \
     2   4   7
     Target = 28
     Output: False*/

    static boolean findTarget(TreeNode root, int k){

        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.peek();
            if (cur != null){
                stack.push(cur.left);
            }else {
                stack.pop();
                if (stack.isEmpty())
                    break;
                cur = stack.pop();
                if(ans.contains((k - cur.val)))
                    return true;
                ans.add(cur.val);

                stack.push(cur.right);
            }
        }
        return false;
    }
}
