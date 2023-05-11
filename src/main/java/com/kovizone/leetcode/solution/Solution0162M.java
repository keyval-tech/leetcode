package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/find-peak-element/">162. 寻找峰值</a>
 * <p>
 * #数组 #二分查找 #中等
 *
 * @author KV
 * @since 2022/08/10
 */
public class Solution0162M {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        System.out.printf("l: %d, c: %d, r: %d, s: %d%n", l, ((l + r) >> 1), r, nums[((l + r) >> 1)]);
        while (l <= r) {
            int c = (l + r) >> 1;
            if (c > 0 && nums[c - 1] > nums[c]) {
                r = c - 1;
            } else if (c < nums.length - 1 && nums[c + 1] > nums[c]) {
                l = c + 1;
            } else {
                return c;
            }
            System.out.printf("l: %d, c: %d, r: %d, s: %d%n", l, ((l + r) >> 1), r, nums[((l + r) >> 1)]);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0162M().findPeakElement(new int[]{5, 4, 3, 4, 5}));
    }
}
