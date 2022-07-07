package com.kovizone.leetcode;

import cn.hutool.json.JSONUtil;

/**
 * <a href="https://leetcode.cn/problems/rotate-array/">189. 轮转数组</a>
 *
 * @author KV
 * @since 2022/07/06
 */
public class Solution0189RotateArray {
    public void rotate(int[] nums, int k) {
        final int l = nums.length;
        if (k != 0 && l > 1 && k != l) {
            int tempIndex = 0;
            int targetIndex = 0;
            int check = 0;
            for (int i = 0; i < l; i++) {
                targetIndex += k %= l;
                if (targetIndex == check) {
                    tempIndex++;
                    targetIndex++;
                    check++;
                    continue;
                }
                // 交换元素
                final int temp = nums[targetIndex];
                nums[targetIndex] = nums[tempIndex];
                nums[tempIndex] = temp;
            }
        }
    }

    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        if (k > 0) {
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }
    }

    public void reverse(int[] nums, int begin, int end) {
        while (begin < end) {
            int t = nums[begin];
            nums[begin] = nums[end];
            nums[end] = t;
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1};

        new Solution0189RotateArray().rotate2(nums, 2);
        System.out.println(JSONUtil.toJsonStr(nums));
    }
}
