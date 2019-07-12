package com.self.leet;

public class MergeSortedList {


    //   Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = null;
        //l1, l2都为空链表，直接返回
        if (l1 == null || l2 == null) {
            return res;
        }
        if (l1 == null) {
            res = l2;
            l2 = l2.next;
        } else if (l2 == null) {
            res = l1;
            l1 = l1.next;
        } else {
            if (l1.val > l2.val) {
                res = l2;
                l2 = l2.next;
            } else {
                res = l1;
                l1 = l1.next;
            }
        }
        ListNode tmp = res;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                tmp.next = l2;
                tmp = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                tmp.next = l1;
                tmp = l1;
                l1 = l1.next;
            } else {
                if (l1.val > l2.val) {
                    tmp.next = l2;
                    tmp = l2;
                    l2 = l2.next;
                } else {
                    tmp.next = l1;
                    tmp = l1;
                    l1 = l1.next;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = null;
        ListNode l2 = new ListNode(0);
        mergeTwoLists(l1,l2);
    }
}
