package com.kovizone.leetcode.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/best-poker-hand/">2347. 最好的扑克手牌</a>
 *
 * @author KV
 * @since 2023/02/20
 */
public class Solution2347 {
    public String bestHand(int[] ranks, char[] suits) {
        boolean isFlush = true;

        int n = ranks.length;
        int maxEq = 1;

        for (int i = 0; i < n; i++) {
            if (isFlush && i > 0 && suits[i] != suits[i - 1]) {
                isFlush = false;
            }
            if (maxEq < 3) {
                int size = 1;
                for (int j = i + 1; j < n; j++) {
                    if (ranks[i] == ranks[j]) {
                        size++;
                    }
                }
                maxEq = Math.max(maxEq, size);
            }
        }

        if (isFlush) {
            return "Flush";
        }
        if (maxEq >= 3) {
            return "Three of a Kind";
        }
        if (maxEq >= 2) {
            return "Pair";
        }
        return "High Card";
    }

    public String bestHand1(int[] ranks, char[] suits) {
        boolean isFlush = true;

        int n = ranks.length;
        Map<Integer, Integer> map = new HashMap<>(n);

        for (int i = 0; i < n; i++) {
            if (isFlush && i > 0 && suits[i] != suits[i - 1]) {
                isFlush = false;
            }

            map.merge(ranks[i], 1, Integer::sum);
        }

        if (isFlush) {
            return "Flush";
        }
        boolean isPair = false;
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            if (entry.getValue() >= 3) {
                return "Three of a Kind";
            }
            if (entry.getValue() == 2) {
                isPair = true;
            }
        }
        if (isPair) {
            return "Pair";
        }

        return "High Card";
    }
}
