package com.company.superme198.PriorityQueue;

import java.util.*;

/**
 * Created by traig on 8:40 AM, 11/15/2018
 */
public class SlidingWindowMaximum {

    static int[] maxSlidingWindow(int[] nums, int k) {
            int len = nums.length;
            if(len == 0) return new int[0];
            int[] ans = new int[len -k +1];
            int idx =0;
            MaxQueue max = new MaxQueue();
            Deque<Integer> deque = new LinkedList<>();
            for(int i =0; i< k; i++){
                max.push(nums[i]);
            }

            ans[idx ++] = max.poll();
            for(int i =k; i< len; i++){
                max.push(nums[i]);
                ans[idx ++] = max.poll();
            }
            return ans;
        }

    static class MaxQueue {

        class Elem{
            int max;
            int val;
            Elem next;
            public Elem(int max, int val){
                this.max = max;
                this.val = val;
            }

        }
        Elem e, head = e;
        /** initialize your data structure here. */
        public MaxQueue() {

        }
        boolean isEmpty(){return e == null;}
        public void push(int x) {
            if(e == null){
                e = new Elem(x, x);

            }else{
                Elem tmp = new Elem(Math.max(e.max, x), x);
                tmp.next = e;
                e = tmp;

            }
        }

        public int poll() {
            if(!isEmpty()){
                head = head.next;
            }
            return head.max;
        }

        public int getMax() {
            if(!isEmpty())
                return e.max;
            return -1;
        }
    }

    public static void main(String...args){

        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3)));
    }
}
