package com.kovizone.leetcode.solution;

import cn.hutool.core.util.ArrayUtil;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/">26. 删除有序数组中的重复项</a>
 * <p>
 * #数组 #双指针
 *
 * @author KV
 * @since 2023/05/08
 */
public class Solution0026E {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int p = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[p]) {
                nums[++p] = nums[i];
            }
        }
        return p + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        System.out.println((new Solution0026E().removeDuplicates(nums)));
        System.out.println(ArrayUtil.toString(nums));

    }
}
