package com.kovizone.leetcode.solution;

import cn.hutool.core.util.StrUtil;

/**
 * <a href="https://leetcode.cn/problems/gas-station/">134. 加油站</a>
 * <p>
 * #贪心 #数组 #中等 #面试经典150题
 *
 * @author KV
 * @since 2023/05/11
 */
public class Solution0134M {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int l = 0;
        int r = 0;
        int core = 0;
        while (l < n && r < n * 2) {
            System.out.println(StrUtil.format("l: {}, r: {}, {}-{}={}", l, r, gas[r % n], cost[r % n], gas[r % n] - cost[r % n]));
            core += gas[r % n] - cost[r % n];
            if (core < 0) {
                core = 0;
                l = r + 1;
                r = l;
            } else if (r - l < n) {
                r++;
            } else {
                return l;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0134M().canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }
}
