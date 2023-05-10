package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/jump-game/">55. 跳跃游戏</a>
 * <p>
 * #贪心 #数组 #动态规划
 *
 * @author KV
 * @see Solution0045M
 * @since 2022/10/24
 */
public class Solution0055M {
    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i <= maxIndex) {
                maxIndex = Math.max(i + nums[i], maxIndex);
                if (maxIndex >= length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canJump1(int[] nums) {
        return canJump(nums, 0, new boolean[nums.length]);
    }

    public boolean canJump(int[] nums, int idx, boolean[] vis) {
        if (idx >= nums.length - 1) {
            return true;
        }
        int num = nums[idx];
        for (int i = num; i >= 1; i--) {
            if (!vis[idx] && canJump(nums, idx + i, vis)) {
                return true;
            }
            vis[idx + i] = true;
        }
        vis[idx] = true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0055M().canJump(new int[]{3, 2, 1, 0, 1}));
    }

}
