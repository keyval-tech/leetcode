package com.kovizone.leetcode.page00;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/">34. 在排序数组中查找元素的第一个和最后一个位置</a>
 *
 * @author KV
 * @since 2022/08/08
 */
public class Solution0034FindFirstLastPositionElementSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int low = -1;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int c = (r - l) / 2 + l;
            if (nums[c] == target) {
                low = c;
            }
            if (nums[c] >= target) {
                r = c - 1;
            } else {
                l = c + 1;
            }
        }

        int hight = -1;
        if(low != -1){
            l = low;
            r = nums.length - 1;
            while (l <= r) {
                int c = (r - l) / 2 + l;
                if (nums[c] == target) {
                    hight = c;
                }
                if (nums[c] <= target) {
                    l = c + 1;
                } else {
                    r = c - 1;
                }
            }
        }
        return new int[]{low, hight};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution0034FindFirstLastPositionElementSortedArray().searchRange(new int[]{1, 2, 2}, 2)));
    }
}
