package com.company.superme198.Arrays;

public class ChangeMoney {


    static void changeMoney(int n){
        for (int i = 10; i >=0 ; i -=5) {
            System.out.println(i /5 + " So To 5");
            int remain = (n- i/5 * 5);
            for (int j = remain - remain % 2 ; j >0 ; j -=2 ) {
                System.out.print("   "+j /2 + " So To 2  ");
                for (int k = 1; k < remain -j ; k ++) {
                    System.out.print(k + " So To 1  ");

                }
            }
            //System.out.println(i /5 + " So To 5" +  "  " + cnt2s/2 +"to 2  " + cnt1s +" To 1" );
        }
    }

    public static void main(String...args){
        changeMoney(10);

    }
}
