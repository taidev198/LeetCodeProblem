package com.company.superme198.LinkedList;

public class MergeSortedLinkedList {
      public class ListNode { int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
    static  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode answer = null;
        ListNode curNode = null;

        while (l1 != null && l2 != null){
            if (l1.val >= l2.val){
                if (answer == null )
                    answer = curNode = l2;
                else{
                    curNode.next = l2;
                    curNode = l2;
                }
                l2 = l2.next;
            }else {
                if (answer == null )
                    answer = curNode = l1;
                else{
                    curNode.next = l1;
                    curNode = l1;
                }
                l1 = l1.next;
            }
        }

        while(l1 != null){
            curNode.next = l1;
            curNode = l1;
            l1 = l1.next;
        }
        while(l2 != null){
            curNode.next = l2;
            curNode = l2;
            l2 = l2.next;
        }
        return answer;
    }
}
