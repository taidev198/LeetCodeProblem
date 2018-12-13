package com.company.superme198.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by traig on 7:10 PM, 12/13/2018
 */
public class OnlineStockSpan {

    static  class StockSpanner {
        Stack<Integer> stack;
        List<Integer> res = new ArrayList<>();
        public StockSpanner() {

        }

        public int next(int price) {
            int count =1;
           boolean isEqual = false;
            for (int i = 0; i < res.size() ; i++) {
                int value = res.get(i);
                if (value <= price)
                count++;
                else break;
                if (value == price)
                    isEqual = true;
            }
            if (isEqual)
                count--;
            insert(price);
            return count;
        }

        public void insert(int price){
            if (res.size() ==0){
                res.add(price);
                return;
            }
            int l = 0, r = res.size() -1;
            while (l < r){
                int m = l + (r -l) /2;
                if (price >= res.get(m))
                    r = m -1;
                else l = m +1;
            }
            if (res.get(l) <= price)
                res.add(l, price);
            else res.add(l+1, price);


        }
    }

    public static void main(String...args){
        StockSpanner ss = new StockSpanner();
        System.out.println(ss.next(1));
        System.out.println(ss.next(2));
        System.out.println(ss.next(2));
        System.out.println(ss.next(1));

    }
}
