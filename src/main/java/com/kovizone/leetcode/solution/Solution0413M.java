package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/arithmetic-slices/">413. 等差数列划分</a>
 * <p>
 * #数组 #动态规划 #中等
 *
 * @author KV
 * @since 2022/10/25
 */
public class Solution0413M {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int n = nums.length;
        int diff = nums[1] - nums[0];
        int ans = 0;
        int t = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == diff) {
                ans += ++t;
            } else {
                diff = nums[i] - nums[i - 1];
                t = 0;
            }
        }
        return ans;
    }
}
