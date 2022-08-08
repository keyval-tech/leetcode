package com.kovizone.leetcode;

import cn.hutool.core.thread.ThreadUtil;

/**
 * <a href="https://leetcode.cn/problems/arranging-coins/">441. 排列硬币</a>
 *
 * @author KV
 * @since 2022/08/08
 */
public class Solution0441ArrangingCoins {
    public int arrangeCoins(int n) {
        int l = 0;
        int r = n;
        while (l <= r) {
            int c = (r - l) / 2 + l;
            long s = ((long) c * (c + 1)) / 2L;
            System.out.printf("l: %d, c: %d, r: %d, s: %d, n: %d%n", l, c, r, s, n);
            if (s > n) {
                r = c - 1;
            } else {
                l = c + 1;
            }
            ThreadUtil.sleep(1000);
        }
        return l - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0441ArrangingCoins().arrangeCoins(1804289383));
    }

    // 01
    // 02 03
    // 04 05 06
    // 07 08 09 10
    // 11 12 13 14 15
    // 16 17 18 19 20 21
    // 22 23 24 25 26 27 28
    // 29 30 31 32 33 34 35 36
    // 37 38 39 40 41 42 43 44 45
    // 46 47 48 49 50 51 52 53 54 55

    // 5 * 6 / 2

    // k * (k + 1) / 2
}