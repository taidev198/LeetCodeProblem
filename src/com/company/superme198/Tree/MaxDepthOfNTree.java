package com.company.superme198.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxDepthOfNTree {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**Solution 1: using Breath First Search*/
    static int maxDepth(Node root) {
        if(root == null)
            return 0;
        if(root.children == null)
            return 1;
        Queue<Node> queue = new LinkedList<>();
        int maxDepth = 0;
        queue.add(root);
        while(!queue.isEmpty()){
            maxDepth++;
            //get List of Children of each root
            int size = queue.size();
            for(int j = 0; j< size; j++){//travel all node in-processing on queue
                Node temp = queue.poll();
                List<Node> childrenOfRoot = temp.children;
                for(int i=0 ;i< childrenOfRoot.size(); i++){
                    queue.add(childrenOfRoot.get(i));//add all node of children list to queue
                }
            }
        }
        return maxDepth;

    }
}
