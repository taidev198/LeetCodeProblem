package com.company.superme198.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTravelNTree {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    static List<List<Integer>> levelOrder(Node root) {
        if(root == null)
            return new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> listLevelOrderTemp = new ArrayList<>();
            //get List of Children of each root
            int size = queue.size();
            for(int j = 0; j< size; j++){//travel all node in-processing on queue
                Node temp = queue.poll();
                listLevelOrderTemp.add(temp.val);//travel root node
                List<Node> childrenOfRoot = temp.children;
                for(int i=0 ;i< childrenOfRoot.size(); i++){
                    queue.add(childrenOfRoot.get(i));//add all node of children list to queue
                }
            }

            ans.add(listLevelOrderTemp);
        }
        return ans;

    }
}
