package com.kovizone.leetcode.solution;

import cn.hutool.json.JSONUtil;

/**
 * <a href="https://leetcode.cn/problems/move-zeroes/">283. 移动零</a>
 *
 * @author KV
 * @since 2022/07/07
 */
public class Solution0283 {
    public void moveZeroes(int[] nums) {
        int l = nums.length;
        int a = 0, b = 1;
        while (b < l) {
            if (nums[a] == 0 && nums[b] != 0) {
                nums[a] = nums[b];
                nums[b] = 0;
                a++;
            }
            if (nums[a] != 0) {
                a++;
            }
            b++;
        }
    }

    public void moveZeroes2(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void moveZeroes3(int[] nums) {
        int a = 0;
        int b = 0;
        int l = nums.length;
        while (b < l) {
            if (nums[b] != 0) {
                nums[a++] = nums[b];
            }
            b++;
        }

        for (int i = a; i < l; i++) {
            nums[i] = 0;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        new Solution0283().moveZeroes3(nums);
        System.out.println(JSONUtil.toJsonStr(nums));
    }
}
