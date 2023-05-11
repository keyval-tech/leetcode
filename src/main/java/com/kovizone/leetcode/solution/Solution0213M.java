package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/house-robber-ii/">213. 打家劫舍 II</a>
 * <p>
 * #数组 #动态规划 #中等
 *
 * @author KV
 * @see Solution0198M
 * @since 2022/10/24
 */
public class Solution0213M {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    public int rob(int[] nums, int start, int length) {
        int l1 = nums[start];
        int l2 = Math.max(l1, nums[start + 1]);
        for (int i = start + 2; i < length; i++) {
            int num = nums[i];
            int temp = l2;
            l2 = Math.max(l1 + num, l2);
            l1 = temp;
        }
        return l2;
    }
}
