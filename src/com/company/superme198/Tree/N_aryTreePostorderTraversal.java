package com.company.superme198.Tree;

import java.util.ArrayList;
import java.util.List;

public class N_aryTreePostorderTraversal {

    /**Link:https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/
     * Given an n-ary tree, return the postorder traversal of its nodes' values.
     *
     * For example, given a 3-ary tree:

     * Return its postorder traversal as: [5,6,3,2,4,1].*/
    static List<Integer> postorder(LevelOrderTravelNTree.Node root) {

        List<Integer> ans = new ArrayList<>();
        postorderHelper(root, ans);
        return ans;
    }

    static void postorderHelper(LevelOrderTravelNTree.Node root, List<Integer> chosen){
        if(root != null){
            List<LevelOrderTravelNTree.Node> chil = root.children;
            for(int i =0; i< chil.size(); i++)
                postorderHelper(chil.get(i), chosen);

            chosen.add(root.val);
        }
    }
}
