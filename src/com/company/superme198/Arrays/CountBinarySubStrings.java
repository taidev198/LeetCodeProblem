package com.company.superme198.Arrays;

public class CountBinarySubStrings {


    static int countBinarySubstrings(String s) {
        int ans = 0;
        int len = s.length();
        if(len == 2) return s.charAt(0) != s.charAt(1)? 1:0;
            for(int j= 0;j <len-1; j++){
                int  right =j+1 ;
                int cnt0s = 1;

                while (len > right ){
                    if ( s.charAt(right) == s.charAt(right-1) ){
                        right++;
                        cnt0s++;
                    } else break;
                }
                right++;
                int c = 1;
                while (len > right ){
                    if ( s.charAt(right) == s.charAt(right-1) && cnt0s != c ){
                        right++;
                       c++;
                    }
                     else break;

                }
                if (cnt0s == c)
                    ans++;
            }
        return ans;
    }

    public static void main(String...args){
        System.out.println(countBinarySubstrings("00110011"));
    }
}
