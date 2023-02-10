package com.kovizone.leetcode.page17;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/design-authentication-manager/">1797. 设计一个验证系统</a>
 *
 * @author KV
 * @since 2023/02/09
 */
public class Solution1797 {

    final int timeToLive;

    final Map<String, ListNode> cache = new HashMap<>();

    /**
     * 指针
     */
    ListNode first;

    public Solution1797(int timeToLive) {
        this.timeToLive = timeToLive;
        this.first = new ListNode("", 0);
    }

    public void generate(String tokenId, int currentTime) {
        ListNode node = new ListNode(tokenId, currentTime + timeToLive);

        cache.put(tokenId, node);

        node.next = first;
        node.next.prev = node;

        first = node;
    }

    public void renew(String tokenId, int currentTime) {
        ListNode node = cache.get(tokenId);
        if (node != null) {
            if (node.prev != null) {
                node.prev.next = node.next;
            } else {
                first = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }

            if (node.timeout > currentTime) {
                generate(tokenId, currentTime);
            }
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int ans = 0;
        ListNode p = this.first;
        while (p.timeout > currentTime) {
            ans++;
            p = p.next;
        }
        return ans;
    }

    private static class ListNode {
        public String tokenId;
        public int timeout;
        private ListNode prev;
        private ListNode next;

        public ListNode(String tokenId, int timeout) {
            this.tokenId = tokenId;
            this.timeout = timeout;
        }
    }

    public static void main(String[] args) {

        Solution1797 solution = new Solution1797(671);
        solution.generate("emebs", 176);
        System.out.println("null");
        System.out.println(solution.countUnexpiredTokens(209));
        System.out.println(solution.countUnexpiredTokens(213));
        System.out.println(solution.countUnexpiredTokens(225));
        System.out.println(solution.countUnexpiredTokens(289));
        System.out.println(solution.countUnexpiredTokens(353));
        System.out.println(solution.countUnexpiredTokens(497));
        System.out.println(solution.countUnexpiredTokens(664));
        System.out.println(solution.countUnexpiredTokens(685));
        solution.generate("ahz", 717);
        System.out.println("null");
        solution.renew("ahz", 788);
        System.out.println("null");
        solution.generate("aofte", 887);
        System.out.println("null");
        System.out.println(solution.countUnexpiredTokens(909));
        solution.generate("ozekk", 927);
        System.out.println("null");
    }
}
