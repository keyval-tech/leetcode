package com.kovizone.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/house-robber/">198. 打家劫舍</a>
 * <p>
 * #数组 #动态规划 #中等
 *
 * @author KV
 * @see Solution0213M
 * @since 2022/08/03
 */
public class Solution0198M {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int l1 = nums[0];
        int l2 = Math.max(l1, nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int num = nums[i];
            int temp = l2;
            l2 = Math.max(l1 + num, l2);
            l1 = temp;
        }
        return l2;
    }

    public int rob1(int[] nums) {
        Map<Integer, Integer> cache = new HashMap<>();
        return Math.max(rob(nums, 1, cache), rob(nums, 0, cache));
    }

    private int rob(int[] nums, int r, Map<Integer, Integer> cache) {
        if (r >= nums.length) {
            return 0;
        }
        Integer s = cache.get(r);
        if (s == null) {
            // 对比隔一个或隔两个
            System.out.println("nums[" + r + "] = " + nums[r]);
            s = Math.max(nums[r] + rob(nums, r + 3, cache), nums[r] + rob(nums, r + 2, cache));
            cache.put(r, s);
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0198M().rob(new int[]{1, 4, 3, 4, 2}));
    }
}
