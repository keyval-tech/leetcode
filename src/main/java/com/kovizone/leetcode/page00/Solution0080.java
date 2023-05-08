package com.kovizone.leetcode.page00;

import cn.hutool.core.util.ArrayUtil;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/">80. 删除有序数组中的重复项 II</a>
 *
 * @author KV
 * @since 2023/05/08
 */
public class Solution0080 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }

        int p = 1;
        for (int i = 2; i < n; i++) {
            if (nums[i] != nums[p] || nums[i] != nums[p - 1]) {
                nums[++p] = nums[i];
            }
        }
        return p + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println((new Solution0080().removeDuplicates(nums)));
        System.out.println(ArrayUtil.toString(nums));
    }
}
