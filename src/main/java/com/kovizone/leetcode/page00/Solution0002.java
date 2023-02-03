package com.kovizone.leetcode.page00;

import com.kovizone.leetcode.core.ListNode;

/**
 * <a href="https://leetcode.cn/problems/add-two-numbers/">2. 两数相加</a>
 *
 * @author KV
 * @since 2023/02/03
 */
public class Solution0002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean flag = false;
        ListNode head = null;
        ListNode tail = null;
        while (l1 != null || l2 != null) {

            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + (flag ? 1 : 0);
            flag = sum >= 10;

            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail = tail.next = new ListNode(sum % 10);
            }


            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (flag) {
            tail.next = new ListNode(1);
        }
        return head;
    }
}
