package com.kovizone.leetcode;

/**
 * <a href="https://leetcode.cn/problems/search-insert-position/">35. 搜索插入位置</a>
 *
 * @author KV
 * @since 2022/07/05
 */
public class Solution0035SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, target, 0, nums.length - 1);
    }

    public int searchInsert(int[] nums, int target, int l, int r) {
        if (l == r) {
            return nums[l] < target ? l + 1 : l;
        }
        if (nums[l] == target) {
            return l;
        }

        int m = (r - l) / 2 + l;
        if (nums[m] >= target) {
            return searchInsert(nums, target, l, m);
        }
        return searchInsert(nums, target, m + 1, r);
    }

    public static void main(String[] args) {
        System.out.println(new Solution0035SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 7));
    }
}
