package com.company.superme198.Tree;

import com.company.superme198.TreeNode;

public class isBalancedTree {

   static boolean isOk = true;
  static   public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return isOk;
    }
   static public int maxDepth(TreeNode root){
        if(root == null)
            return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if((int)Math.abs(l - r) >1)
            isOk = false;
        return 1+ Math.max(l, r );
    }
}
