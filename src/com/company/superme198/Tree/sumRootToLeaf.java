package com.company.superme198.Tree;

public class sumRootToLeaf {

      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

     static int sumNumbers(TreeNode root) {
         return   sumTreeNumbers(root, 0);

    }
   static  int sumTreeNumbers(TreeNode root, int sum) {
       if( root == null ) return 0;
       int newSum = sum*10 + root.val;
       if(root.left == null && root.right == null) return newSum;
       return sumTreeNumbers(root.left, newSum) + sumTreeNumbers(root.right,newSum);
   }

    public static void main(String[] args) {
        // write your code here

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(sumNumbers(root));

    }
}
