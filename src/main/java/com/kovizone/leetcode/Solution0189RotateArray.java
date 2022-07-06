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
                targetIndex += k;
                if (targetIndex >= l) {
                    targetIndex = targetIndex - l * (targetIndex / l);
                }
                if (targetIndex == check) {
                    tempIndex++;
                    targetIndex++;
                    check++;
                    continue;
                }
                System.out.println("nums: " + JSONUtil.toJsonStr(nums) + ", insert num: \t" + nums[tempIndex] + "\t, insert index: \t" + targetIndex);
                // 交换元素
                final int temp = nums[targetIndex];
                nums[targetIndex] = nums[tempIndex];
                nums[tempIndex] = temp;
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};

        new Solution0189RotateArray().rotate(nums, 2);
        System.out.println(JSONUtil.toJsonStr(nums));
    }
}
