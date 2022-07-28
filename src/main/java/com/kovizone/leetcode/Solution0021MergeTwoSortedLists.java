package com.kovizone.leetcode;

/**
 * <a href="https://leetcode.cn/problems/merge-two-sorted-lists/">21. 合并两个有序链表</a>
 *
 * @author KV
 * @since 2022/07/13
 */
public class Solution0021MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root = new ListNode();
        ListNode h = root;
        ListNode h1 = list1;
        ListNode h2 = list2;

        while (h1 != null || h2 != null) {
            if (h1 == null) {
                h.next = h2;
                break;
            }
            if (h2 == null) {
                h.next = h1;
                break;
            }

            if (h1.val <= h2.val) {
                h.next = new ListNode(h1.val);
                h1 = h1.next;
            } else {
                h.next = new ListNode(h2.val);
                h2 = h2.next;
            }

            h = h.next;
        }
        return root.next;
    }
}
