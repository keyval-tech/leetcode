package com.kovizone.leetcode.core;

import com.kovizone.leetcode.page00.Solution0019RemoveNthNodeFromEndList;
import com.kovizone.leetcode.page08.Solution0876MiddleLinkedList;

/**
 * ListNode
 *
 * @author KV
 * @see Solution0876MiddleLinkedList
 * @see Solution0019RemoveNthNodeFromEndList
 * @since 2022/07/07
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {
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

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int... valArr) {
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
