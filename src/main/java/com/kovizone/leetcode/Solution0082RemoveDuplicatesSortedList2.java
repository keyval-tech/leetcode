package com.kovizone.leetcode;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/">82. 删除排序链表中的重复元素 II</a>
 *
 * @author KV
 * @since 2022/08/10
 */
public class Solution0082RemoveDuplicatesSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode root = new ListNode();
        ListNode p1 = root;

        int lastVal = 101;
        while (head != null) {
            if (head.val != lastVal && (head.next == null || head.val != head.next.val)) {
                p1.next = head;
                p1 = p1.next;
            }
            lastVal = head.val;
            head = head.next;
        }
        p1.next = null;
        return root.next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0082RemoveDuplicatesSortedList2().deleteDuplicates(new ListNode(1, 2, 3, 3, 4, 4)));
    }
}
