package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/trapping-rain-water/">42. 接雨水</a>
 * <p>
 * #栈 #数组 #双指针 #动态规划 #单调栈 #困难 #面试经典150题
 *
 * @author KV
 * @since 2023/02/03
 */
public class Solution0042H {
    public int trap(int[] height) {
        int sum = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    sum += leftMax - height[left];
                }
                ++left;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    sum += rightMax - height[right];
                }
                --right;
            }
        }
        return sum;

    }
}
