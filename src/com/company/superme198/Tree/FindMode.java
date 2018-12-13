package com.company.superme198.Tree;

import com.company.superme198.TreeNode;

import java.util.Arrays;

public class FindMode {

    static int[] findMode(TreeNode root) {
        if(root == null) return new int[0];
        if(root.left == null && root.right == null)
            return new int[]{root.val};
        int[] ans = new int[100];
        Integer idx = new Integer(0);
        inorder(root, ans, idx, root.val);
        return ans;
    }

    static int inorder(TreeNode root, int[] ans, Integer idx, Integer pre){
        if (root == null )
            return Integer.MIN_VALUE;
        int leftVal;
        int rightVal;
          leftVal =  inorder(root.left, ans, idx, root.val);
            if(leftVal == root.val && Integer.MIN_VALUE != leftVal)
                ans[idx++] = leftVal;
         leftVal = inorder(root.right, ans, idx, root.val);
         return root.val;
    }
    public static void main(String...args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        System.out.println(Arrays.toString(findMode(root)));
    }
}
