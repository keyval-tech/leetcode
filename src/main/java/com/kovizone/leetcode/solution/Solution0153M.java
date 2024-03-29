package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/">153. 寻找旋转排序数组中的最小值</a>
 * <p>
 * #数组 #二分查找 #中等
 *
 * @author KV
 * @since 2022/08/10
 */
public class Solution0153M {
    public int findMin(int[] nums) {
        int min = nums[nums.length - 1];
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int c = (l + r) >> 1;
            int s = nums[c];
            if (s > min) {
                l = c + 1;
            } else {
                if (s < min) {
                    min = s;
                }
                r = c - 1;
            }
        }
        return min;
    }
}
