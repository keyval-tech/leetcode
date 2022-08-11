package com.kovizone.leetcode.page00;

/**
 * <a href="https://leetcode.cn/problems/search-in-rotated-sorted-array/">33. 搜索旋转排序数组</a>
 *
 * @author KV
 * @since 2022/08/10
 */
public class Solution0033SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int flag = nums[nums.length - 1];
        if (flag == target) {
            return nums.length - 1;
        }
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int c = (l + r) >> 1;
            int s = nums[c];
            if (s == target) {
                return c;
            }
            if ((target >= flag && s > target) || (s <= flag && (target > flag || s > target))) {
                r = c - 1;
            } else {
                l = c + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 8, 1, 2, 3};
        System.out.println(new Solution0033SearchRotatedSortedArray().search(nums, 3));
    }

}
