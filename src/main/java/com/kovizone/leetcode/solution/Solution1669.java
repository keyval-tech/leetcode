package com.kovizone.leetcode.solution;

import com.kovizone.leetcode.core.ListNode;

/**
 * <a href="https://leetcode.cn/problems/merge-in-between-linked-lists/">1669. 合并两个链表</a>
 *
 * @author KV
 * @since 2023/01/30
 */
public class Solution1669 {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode p0 = list1;
        ListNode p1 = list1;

        for (int i = 0; i < b; i++) {
            if (i < a - 1) {
                p0 = p0.next;
            }
            p1 = p1.next;
        }

        ListNode p2 = list2;
        while (p2.next != null) {
            p2 = p2.next;
        }

        p0.next = list2;
        p2.next = p1.next;
        return list1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1669().mergeInBetween(
                new ListNode(0, 1, 2, 3, 4),
                2,
                2,
                new ListNode(-1, -2, -3)
        ));
    }

}