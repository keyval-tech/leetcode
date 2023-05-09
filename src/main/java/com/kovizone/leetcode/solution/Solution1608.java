package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/special-array-with-x-elements-greater-than-or-equal-x/">1608. 特殊数组的特征值</a>
 *
 * @author KV
 * @since 2022/08/09
 */
public class Solution1608 {

    public static void main(String[] args) {
        System.out.println(new Solution1608().specialArray(new int[]{3, 9, 7, 8, 3, 8, 6, 6}));
        // 9 8 8 7 6 6 3 3
        // 7 >= 4 && c < 4
        System.out.println(new Solution1608().specialArray(new int[]{3, 6, 7, 7, 0}));
    }

    public int specialArray(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        quickSort(nums, l, r);

        int s = -1;
        while (l <= r) {
            int c = (l + r) >> 1;
            if (nums[c] >= (c + 1)) {
                if (c == nums.length - 1 || nums[c + 1] < (c + 1)) {
                    s = c + 1;
                }
                l = c + 1;
            } else {
                r = c - 1;
            }
        }
        return s;
    }

    public void quickSort(int[] nums, int low, int height) {
        if (low >= height) {
            return;
        }
        int l = low, h = height;
        int p = nums[l];
        while (l < h) {
            while (nums[h] <= p && l < h) {
                h--;
            }
            while (nums[l] >= p && l < h) {
                l++;
            }
            if (l != h) {
                int temp = nums[l];
                nums[l] = nums[h];
                nums[h] = temp;
            }
        }
        if (l != low) {
            int temp = nums[l];
            nums[l] = nums[low];
            nums[low] = temp;
        }
        quickSort(nums, low, l - 1);
        quickSort(nums, l + 1, height);
    }
}
