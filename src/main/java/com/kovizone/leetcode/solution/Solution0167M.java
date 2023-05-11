package com.kovizone.leetcode.solution;

import cn.hutool.json.JSONUtil;

/**
 * <a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/">167. 两数之和 II - 输入有序数组</a>
 * <p>
 * #数组 #双指针 #二分查找 #中等
 *
 * @author KV
 * @since 2022/07/07
 */
public class Solution0167M {
    public int[] twoSum(int[] nums, int target) {
        return twoSum(nums, target, 0, nums.length - 1);
    }

    public int[] twoSum(int[] nums, int target, int l, int r) {
        if (nums[l] + nums[r] == target) {
            return new int[]{l + 1, r + 1};
        }
        if (nums[r] > target || nums[l] + nums[r] > target) {
            return twoSum(nums, target, l, r - 1);
        }
        return twoSum(nums, target, l + 1, r);
    }

    public static void main(String[] args) {
        System.out.println(JSONUtil.toJsonStr(new Solution0167M().twoSum(new int[]{-1, 0, -1, 0}, -2)));
    }
}
