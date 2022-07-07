package com.kovizone.leetcode;

/**
 * <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/">19. 删除链表的倒数第 N 个结点</a>
 *
 * @author KV
 * @see ListNode
 * @since 2022/07/07
 */
public class Solution0019RemoveNthNodeFromEndList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int l = 0;
        ListNode root = new ListNode(0, head);
        ListNode p = root;
        while (p.next != null) {
            p = p.next;
            l++;
        }
        p = root;
        for (int i = 0; i < (l - n); i++) {
            p = p.next;
        }
        if (p.next != null) {
            p.next = p.next.next;
        }
        return root.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode root = new ListNode(0, head);
        ListNode p1 = root;
        ListNode p2 = root;
        int m = 0;
        while (m < n) {
            p1 = p1.next;
            m++;
        }
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return root.next;
    }

    public static void main(String[] args) {
        ListNode root = ListNode.of(1, 2, 3, 4);
        System.out.println(new Solution0019RemoveNthNodeFromEndList().removeNthFromEnd2(root, 1));
    }
}
