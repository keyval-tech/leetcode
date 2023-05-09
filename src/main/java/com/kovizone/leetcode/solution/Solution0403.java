package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/frog-jump/">403. 青蛙过河</a>
 *
 * @author KV
 * @since 2023/02/03
 */
public class Solution0403 {
    public boolean canCross(int[] stones) {
        if (stones[0] != 0 || stones[1] != 1) {
            return false;
        }
        boolean[][] memo = new boolean[stones.length][stones.length];
        return method(stones, 1, 1, memo);
    }

    /**
     * @param stones   单元格集
     * @param index    青蛙所在索引
     * @param lastStep 上一次的步数
     * @return 结果
     */
    public boolean method(int[] stones, int index, int lastStep, boolean[][] memo) {
        if (index == stones.length - 1) {
            return true;
        }

        for (int i = index + 1; i < stones.length; i++) {
            int step = stones[i] - stones[index];
            int num = step - lastStep;
            if (num > 1) {
                return false;
            }

            if (num >= -1 && !memo[index][step]) {
                memo[index][step] = true;
                if (method(stones, i, step, memo)) {
                    return true;
                }
            }
        }
        return false;
    }
}
