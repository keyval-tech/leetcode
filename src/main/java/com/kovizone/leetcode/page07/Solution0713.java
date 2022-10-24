package com.kovizone.leetcode.page07;

import cn.hutool.json.JSONUtil;

/**
 * <a href="https://leetcode.cn/problems/subarray-product-less-than-k/">713. 乘积小于 K 的子数组</a>
 *
 * @author KV
 * @since 2022/08/12
 */
public class Solution0713 {
    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            System.out.println("i: " + i);
            int a = numSubarrayProductLessThanK(nums, k, 1, i);
            System.out.println("ans: " + a);
            ans += a;
            System.out.println();
        }
        return ans;
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        int x = 1;
        for (int p1 = 0, p2 = 0; p2 < nums.length; p2++) {
            x *= nums[p2];
            while (p1 <= p2 && x >= k) {
                x /= nums[p1++];
            }
            ans += p2 - p1 + 1;
        }
        return ans;
    }

    public int numSubarrayProductLessThanK(final int[] nums, final int k, int s, int l) {
        if (l >= nums.length) {
            return 0;
        }

        int[] nums2 = new int[nums.length - l];
        System.arraycopy(nums, l, nums2, 0, nums.length - l);

        System.out.printf("l: %d, nums2: %s, k: %d, s: %d%n", l, JSONUtil.toJsonStr(nums2), k, s);

        s *= nums[l];
        if (s >= k) {
            return 0;
        }
        return 1 + numSubarrayProductLessThanK(nums, k, s, l + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution0713().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }
}
