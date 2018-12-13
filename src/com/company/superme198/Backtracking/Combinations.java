package com.company.superme198.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {



    static List<List<Integer>> combine(int n, int k) {

        boolean[] visited = new boolean[n+1];
        List<List<Integer>> ans = new ArrayList<>();
        combineHelper(n, k, ans, new ArrayList<>(), visited);
        return ans;

    }

    static void combineHelper(int n, int k, List<List<Integer>> ans, List<Integer> chosen, boolean[] visited){
        if(chosen.size() == k){
          //  if(!ans.contains(chosen) )
                ans.add(new ArrayList(chosen));
        }else{
            for(int i =1; i <= n ;i++){
                if(!visited[i]){
                    visited[i] = true;
                    if(chosen.size() ==0  || chosen.get(chosen.size()-1 ) < i){
                        chosen.add(i);
                    }
                    combineHelper(n, k, ans, chosen, visited);
                    visited[i] = false;
                    if (chosen.size() > 0){
                        chosen.remove(chosen.size() -1);
                    }


                }
            }
        }
    }

    public static void main(String...args){

        System.out.println(combine(5,4));
    }
}
