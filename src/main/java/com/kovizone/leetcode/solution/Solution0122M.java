package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/">122. 买卖股票的最佳时机 II</a>
 * <p>
 * 121. 买卖股票的最佳时机 {@link Solution0121E}
 * <p>
 * #贪心 #数组 #动态规划 #中等
 *
 * @author KV
 * @since 2023/05/09
 */
public class Solution0122M {
    public int maxProfit(int[] prices) {
        int res = 0;
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            res += Math.max(prices[i] - prices[i - 1], 0);
        }
        return res;
    }
}
