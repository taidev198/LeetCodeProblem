package com.company.superme198.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    static List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        HashMap<Integer, List<String>> hashMap = new HashMap<>();
        for(int i =0; i< len; i++){
            List<String> tmp = new ArrayList<>();
            int key = wordToInt(strs[i]) ;
            if(!hashMap.containsKey(key)){
                tmp.add(strs[i]);
                hashMap.put(key, tmp);
            }else {
                tmp = hashMap.get(key);
                List<String> temp = new ArrayList<>(tmp);
                temp.add(strs[i]);
                hashMap.replace(key, tmp, temp);
            }
        }
        return new ArrayList<>(hashMap.values());
    }

    static int wordToInt(String arg){
        int ans =0;
        for(int i=0; i< arg.length(); i++)
            ans += (arg.charAt(i) -'0');
        return ans;
    }

    public static void main(String...args){

        System.out.println(Arrays.toString(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}).toArray()));
    }
}
