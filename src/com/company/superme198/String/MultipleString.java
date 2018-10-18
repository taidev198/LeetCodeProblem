package com.company.superme198.String;

import java.util.Arrays;

public class MultipleString {

    static String multiply(String num1, String num2) {

        int lenNum2 = num2.length();
        int lenNum1 = num1.length();
        StringBuilder tmp = new StringBuilder();
        int carry  =0;
        String ans = "0";
        for(int i= lenNum2 -1;i>= 0; i--){
            StringBuilder res1 = new StringBuilder();
            int j = lenNum1 -1;
            while(j >=0){
                int value = (num2.charAt(i) - '0') * (num1.charAt(j) -'0');
                res1.insert(0,(carry +value) % 10);
                carry = value /10;
                j--;
            }
            if (carry != 0)
                res1.insert(0, carry);
            res1.append(tmp);
            ans = addStrings(ans, res1.toString());
            tmp.append("0");
        }

        return ans;
    }
    static String addStrings(String num1, String num2) {
        int nA = num1.length();
        int nB = num2.length();
        char[] ans = new  char[Math.max(nA, nB)+1];
        Arrays.fill(ans, '0');
        int i = nA-1;
        int j = nB-1;
        int k = ans.length-1;
        while(i>=0 && j>=0){
            int tmp = (num1.charAt(i) -'0') + (num2.charAt(j) -'0')+(ans[k]-'0');
            if( tmp < 10)
                ans[k--] =  (char) (tmp +'0');
            else  {
                ans[k--] =  (char) (tmp%10 +'0');
                ans[k] = '1';
            }
            i--;
            j--;
        }
        while(i>=0){
            int tmp = (num1.charAt(i) -'0') +(ans[k]-'0');
            if(tmp<10)
                ans[k--] = (char) (tmp +'0');
            else{
                ans[k--] = (char) (tmp%10 +'0');
                ans[k] = '1';
            }
            i--;
        }
        while(j>=0){
            int tmp = (num2.charAt(j) -'0') +(ans[k]-'0');
            if(tmp<10)
                ans[k--] = (char) (tmp +'0');
            else{
                ans[k--] = (char) (tmp%10 +'0');
                ans[k] = '1';
            }
            j--;
        }
        if (ans[k] == '0')
            return new String(Arrays.copyOfRange(ans, k+1, ans.length));
        return new String(Arrays.copyOfRange(ans, k, ans.length));

    }

    public static void main(String...args){

        System.out.println(multiply("9", "99"));
    }
}
