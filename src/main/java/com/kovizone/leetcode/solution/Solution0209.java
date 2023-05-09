package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/">209. 长度最小的子数组</a>
 *
 * @author KV
 * @since 2022/08/15
 */
public class Solution0209 {
    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        int min = 0;
        int x = nums[0];
        int p1 = 0, p2 = 0;
        while (p1 < length) {
            System.out.printf("p1: %d, p2: %d, x: %d%n", p1, p2, x);
            while (p2 < length - 1 && x < target) {
                x += nums[++p2];
                System.out.printf("p1: %d, p2: %d, x: %d%n", p1, p2, x);
            }
            if (x >= target) {
                if (min == 0) {
                    min = p2 - p1 + 1;
                } else {
                    min = Math.min(min, p2 - p1 + 1);
                }
                System.out.println("min: " + min);
            }
            x -= nums[p1++];
            System.out.println();
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0209().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
