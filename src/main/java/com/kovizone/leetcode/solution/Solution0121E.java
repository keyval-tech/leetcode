package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/">121. 买卖股票的最佳时机</a>
 * <p>
 * 122. 买卖股票的最佳时机 II{@link Solution0122M}
 *
 * #数组 #动态规划 #简单
 *
 * @author KV
 * @since 2023/05/09
 */
public class Solution0121E {
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else {
                res = Math.max(res, price - min);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 6, 4, 3, 1};


        System.out.println(new Solution0121E().maxProfit(nums));
    }
}
