package com.kovizone.leetcode.page00;

/**
 * <a href="https://leetcode.cn/problems/container-with-most-water/">11. 盛最多水的容器</a>
 *
 * @author KV
 * @since 2022/08/11
 */
public class Solution0011 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0011().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
