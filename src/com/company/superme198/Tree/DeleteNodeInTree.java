package com.company.superme198.Tree;

import com.company.superme198.TreeNode;

public class DeleteNodeInTree {

    static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return root;
        TreeNode cur = root;
        TreeNode parent = cur;
        while(cur != null){
            if(cur.val == key){
                TreeNode deletedNode = cur;
                if(cur.left != null && cur.right != null){
                    cur = cur.right;
                    while(cur.left!= null){
                        parent = cur;
                        cur = cur.left;
                    }
                    if(cur == deletedNode.right){
                        if (deletedNode == root){
                            cur.left = root.left;
                            root = cur;
                        }else {
                            cur.left = deletedNode.left;
                            if (deletedNode.val < parent.val)
                                parent.left = cur;
                            else parent.right = cur;
                        }
                    }else{
                        if (deletedNode == root){
                            cur.left = root.left;
                            cur.right = root.right;
                            root = cur;
                        }else {
                            parent.left = cur.right;
                            cur.right = deletedNode.right;
                            cur.left = deletedNode.left;
                            parent.right = cur;
                        }
                    }
                }
                else{
                    if(cur.left == null && cur.right == null){
                        if (root == cur)
                            root = null;
                        else {
                            if (cur.val > parent.val)
                                parent.right = null;
                            else parent.left = null;
                        }
                    }
                    else{
                        if(cur.right == null)
                            deletedNode = cur.left;
                        else deletedNode = cur.right;
                        if(cur == root)
                            root  = deletedNode;
                        else{
                            if(  parent.val > deletedNode.val )
                                parent.left = deletedNode;
                            else if (  parent.val < deletedNode.val)
                                parent.right = deletedNode;
                        }
                    }
                }
                break;
            }else if(cur.val > key){
                parent = cur;
                cur = cur.left;
            }

            else{
                parent = cur;
                cur = cur.right;
            }
        }
        return root;
    }

    public static void main(String...args){

//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(3);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);
//
//        root.right = new TreeNode(6);
//        root.right.right = new TreeNode(7);
//        System.out.println(deleteNode(root, 3));

        
    }
}
