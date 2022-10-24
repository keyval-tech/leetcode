package com.kovizone.leetcode.page08;

import com.kovizone.leetcode.core.ListNode;

/**
 * <a href="https://leetcode.cn/problems/middle-of-the-linked-list/">876. 链表的中间结点</a>
 *
 * @author KV
 * @see ListNode
 * @since 2022/07/07
 */
public class Solution0876 {
    public ListNode middleNode(ListNode head) {
        int l = 1;
        ListNode mp = head;
        ListNode p = head;
        while (p.next != null) {
            l++;
            p = p.next;
            if (l % 2 == 0) {
                mp = mp.next;
            }
        }
        return mp;
    }

    public ListNode middleNode2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode root = ListNode.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(root);
        System.out.println(new Solution0876().middleNode2(root));
    }

}
