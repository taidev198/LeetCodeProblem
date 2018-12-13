package com.company.superme198.String;

/**
 * Created by traig on 2:34 PM, 11/26/2018
 */
public class RepeatedStringMatch {

    static int repeatedStringMatch(String A, String B) {
        int lenA = A.length(), lenB = B.length();
        StringBuilder temp = new StringBuilder(A);
        StringBuilder ABuilder = new StringBuilder(A);
        int ans =0;
        if ((!isSub(B, A) && lenA <= lenB) || (!isSub(A, B) && lenA > lenB))
            return -1;
        while(true){
            ABuilder.append(temp);
            ans++;
            if (isSub(String.valueOf(ABuilder), B))
                return ans;
        }
    }

     static boolean isSub(String A, String B){

         for (int j = 0; j < A.length(); j++) {
             if (A.charAt(j) == B.charAt(0)){
                 int k =j;
                 int i =0;
                 while(i < B.length() && k<A.length() && A.charAt(k) == B.charAt(i)){
                     i++; k++;
                 }
                 if(i == B.length())
                     return true;
             }

         }
         return false;
    }

    public static void main(String...args){
        System.out.println(repeatedStringMatch("abcabcabcabc","abac"));
    }
}
