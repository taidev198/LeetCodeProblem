package com.company.superme198.String;

public class NumberOfMatchingSubsequence {


    static int numMatchingSubseq(String S, String[] words) {
        int len = words.length;
        int ans = 0;
        for(int i= 0; i< len ;i++){
            int j =0;
            int cnt= 0;
            while(j < S.length()){
                int l = 0, r = words[i].length()-1;
                while(l <= r){
                    int m = l + (r -l )/2;
                    if(words[i].charAt(m) == S.charAt(j)){
                        cnt++;
                        break;
                    }else if(words[i].charAt(m) < S.charAt(j))
                        l = m +1;
                    else r = m-1;
                }
                j++;
            }
            if(cnt == words[i].length())
                ans++;
        }
        return ans;
    }

    public static void main(String...args){

        System.out.println(numMatchingSubseq("btovxbkumc", new String[]{"btovxbku","to","zueoxxxjme","yjkclbkbtl"}));
    }
}
