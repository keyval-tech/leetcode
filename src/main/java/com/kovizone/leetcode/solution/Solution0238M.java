package com.kovizone.leetcode.solution;

import cn.hutool.core.util.ArrayUtil;

/**
 * <a href="https://leetcode.cn/problems/product-of-array-except-self/">238. 除自身以外数组的乘积</a>
 * <p>
 * #数组 #前缀和 #中等
 *
 * @author KV
 * @since 2023/05/10
 */
public class Solution0238M {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }
        int temp = 1;
        for (int i = n - 2; i >= 0; i--) {
            temp = nums[i + 1] * temp;
            res[i] *= temp;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(ArrayUtil.toString(new Solution0238M().productExceptSelf(new int[]{1, 2, 3, 4})));

        // 01 02 03 04

        // 01 01 02 06
        // 24 12 04 01

        //          06

        // 24 12 08 06
    }
}
