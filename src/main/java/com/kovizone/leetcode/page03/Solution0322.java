package com.kovizone.leetcode.page03;

import cn.hutool.core.util.ArrayUtil;

/**
 * <a href="https://leetcode.cn/problems/coin-change/">322. 零钱兑换</a>
 *
 * @author KV
 * @since 2023/02/03
 */
public class Solution0322 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];

        for (int total = 1; total < dp.length; total++) {
            // 这里的amount代表标记一种无法达到的结果，在下面的逻辑中有判断到
            int min = amount;
            for (int coin : coins) {
                if (total >= coin && dp[total - coin] <= amount) {
                    min = Math.min(min, dp[total - coin]);
                }
            }
            dp[total] = min + 1;
            System.out.println("dp: " + ArrayUtil.toString(dp));
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Solution0322().coinChange(new int[]{3, 5, 7}, 12));
    }
}
