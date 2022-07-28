package com.kovizone.leetcode;

/**
 * ListNode
 *
 * @author KV
 * @see Solution0876MiddleLinkedList
 * @see Solution0019RemoveNthNodeFromEndList
 * @since 2022/07/07
 */
public class ListNode {

    int val;

    ListNode next;

    ListNode() {
    }

    public static ListNode of(int... valArr) {
        ListNode head = new ListNode();
        ListNode p = head;
        for (int i : valArr) {
            p.next = new ListNode(i);
            p = p.next;
        }
        return head.next;
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(int... valArr) {
        this(valArr[0]);
        if (valArr.length > 1) {
            ListNode p = this;
            for (int i = 1; i < valArr.length; i++) {
                p.next = new ListNode(valArr[i]);
                p = p.next;
            }
        }
    }

    @Override
    public String toString() {
        return "[" + val + "]" + (next == null ? "" : "->" + next.toString());
    }
}
