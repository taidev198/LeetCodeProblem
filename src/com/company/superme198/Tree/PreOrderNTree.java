package com.company.superme198.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderNTree {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**Link: https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/*/
    List<Integer> preorder(Node root) {
        if(root == null)
            return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        ans.add(root.val);
        while(!stack.isEmpty()){
            Node top = stack.peek();
            if(top != null){

                if(top.children.size() >0 ){
                    ans.add(top.children.get(0).val);
                    stack.push(top.children.get(0));
                    List<Node> temp = top.children;
                    temp.remove(0);
                }
                else stack.pop();
            }else
                stack.pop();
        }

        return ans;
    }
}
