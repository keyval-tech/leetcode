package com.kovizone.leetcode.solution;

import cn.hutool.core.util.ArrayUtil;

/**
 * <a href="https://leetcode.cn/problems/merge-sorted-array/">88. 合并两个有序数组</a>
 *
 * #数组 #双指针 #排序 #简单 #面试经典150题
 *
 * @author KV
 * @since 2023/02/03
 */
public class Solution0088E {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = nums1.length - 1;

        while (p1 >= 0 && p2 >= 0) {
            System.out.println(ArrayUtil.toString(nums1) + ", p1: " + p1 + ", p2: " + p2);
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }
        System.out.println(ArrayUtil.toString(nums1) + ", p1: " + p1 + ", p2: " + p2);
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 4, 5, 0, 0, 0};
        int[] nums2 = new int[]{1, 2, 3};
        new Solution0088E().merge(nums1, 3, nums2, 3);
    }
}
