package com.company.superme198.String;

public class BuddyStrings {

    static boolean buddyStrings(String A, String B) {
            int n = A.length();
            int m = B.length();
            if(n != m) return false;
            int countDiff =0;
            int countSame =0;
            int left = 0;
            boolean isSame = false;
            while(left < n){
                if(A.charAt(left) != B.charAt(left))
                    countDiff++;
                if(left >0 && A.charAt(left-1) == A.charAt(left))
                    countSame ++;
                if(countDiff >2)
                    return false;
                left ++;

            }

            return (countSame >=2 && countDiff ==0) || countDiff >=2;
        }

    public static void main(String...args){
        System.out.println(buddyStrings("abcd", "abcd"));

    }
}
