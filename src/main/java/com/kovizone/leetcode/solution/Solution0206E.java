package com.kovizone.leetcode.solution;

import com.kovizone.leetcode.core.ListNode;

/**
 * <a href="https://leetcode.cn/problems/reverse-linked-list/">206. 反转链表</a>
 * <p>
 * #递归 #链表 #简单
 *
 * @author KV
 * @since 2022/07/28
 */
public class Solution0206E {
    public ListNode reverseList(ListNode head) {
        ListNode root = new ListNode();
        ListNode lastP = null;
        ListNode p = head;
        while (p != null) {
            ListNode nodeTemp = p.next;
            root.next = p;
            p.next = lastP;
            lastP = p;
            p = nodeTemp;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, 2, 3, 4, 5);
        System.out.println(new Solution0206E().reverseList(listNode));
    }
}
