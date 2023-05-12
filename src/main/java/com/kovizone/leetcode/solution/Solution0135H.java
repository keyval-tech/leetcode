package com.kovizone.leetcode.solution;

import cn.hutool.core.util.ArrayUtil;

/**
 * <a href="https://leetcode.cn/problems/candy/">135. 分发糖果</a>
 * <p>
 * #贪心 #数组 #困难 #面试经典150题
 *
 * @author KV
 * @since 2023/05/12
 */
public class Solution0135H {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] nums = new int[n];
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            if (ratings[i] > ratings[j]) {
                nums[i] = Math.max(nums[i], nums[j] + 1);
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            int j = i + 1;
            if (ratings[i] > ratings[j]) {
                nums[i] = Math.max(nums[i], nums[j] + 1);
            }
        }

        int res = n;
        for (int num : nums) {
            res += num;
        }
        return res;
    }

    /**
     * 01 02 87 87 87 02 01
     * 01 02 03 01 03 02 01
     */
    public static void main(String[] args) {

        System.out.println(new Solution0135H().candy(new int[]{1, 2, 87, 87, 87, 2, 1}));
    }
}
