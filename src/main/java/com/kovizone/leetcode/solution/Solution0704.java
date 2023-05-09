package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/binary-search/">704. 二分查找</a>
 *
 * @author KV
 * @since 2022/07/05
 */
public class Solution0704 {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public int search(int[] nums, int target, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            return -1;
        }
        if (leftIndex == rightIndex) {
            return nums[leftIndex] == target ? leftIndex : -1;
        }

        int middle = (rightIndex - leftIndex) / 2 + leftIndex;
        if (nums[middle] == target) {
            return middle;
        }
        if (nums[middle] > target) {
            return search(nums, target, leftIndex, middle);
        }
        return search(nums, target, middle + 1, rightIndex);
    }

    public static void main(String[] args) {
        System.out.println(new Solution0704().search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }
}
