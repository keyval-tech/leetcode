package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/container-with-most-water/">11. 盛最多水的容器</a>
 * <p>
 * #贪心 #数组 #双指针 #中等
 *
 * @author KV
 * @since 2022/08/11
 */
public class Solution0011M {
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
        System.out.println(new Solution0011M().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
