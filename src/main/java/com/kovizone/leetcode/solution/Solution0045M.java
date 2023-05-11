package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/jump-game-ii/">45. 跳跃游戏 II</a>
 * <p>
 * #贪心 #数组 #动态规划 #中等
 *
 * @author KV
 * @see Solution0055M
 * @since 2022/10/24
 */
public class Solution0045M {
    public int jump(int[] nums) {
        int length = nums.length;
        int steps = 0;
        int maxIndex = 0;
        int node = 0;
        for (int i = 0; i < length; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if (i == node) {
                steps++;
                node = maxIndex;
            }
        }
        return steps;
    }


    public static void main(String[] args) {
        System.out.println(new Solution0045M().jump(new int[]{2, 3, 1, 1, 0, 4}));
    }
}
