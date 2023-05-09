package com.kovizone.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/minimum-number-of-taps-to-open-to-water-a-garden/">1326. 灌溉花园的最少水龙头数目</a>
 *
 * @author KV
 * @since 2023/02/21
 */
public class Solution1326 {
    public int minTaps(int n, int[] ranges) {
        List<Integer> retain = new ArrayList<>();

        int p = 0;
        for (int i = 1; i < n + 1; i++) {
            int l = i - ranges[i];
            int r = i + ranges[i];

            int pl = p - ranges[p];
            int pr = p + ranges[p];

            // 被p包围
            if (pl < l && r < pr) {
                continue;
            }

            // 包围了p，替换p
            if (l <= pl && pr <= r) {
                p = i;
                continue;
            }

            retain.add(p);
            p = i;
        }

        System.out.println(retain);
        // TODO 未解决

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1326().minTaps(35, new int[]{
                // 00-04
                1, 0, 4, 0, 4,
                // 05-09
                1, 4, 3, 1, 1,
                // 10-14
                1, 2, 1, 4, 0,
                // 15-19
                3, 0, 3, 0, 3,
                // 20-24
                0, 5, 3, 0, 0,
                // 25-29
                1, 2, 1, 2, 4,
                // 30-34
                3, 0, 1, 0, 5,
                // 35
                2}));

        //                    00 01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35

        // 00,01 [00,01]      --
        // 02,04 [00,06]      -- -- -- -- -- -- --
        // 04,04 [00,08]      -- -- -- -- -- -- -- -- --
        // 05,01 [04,06]                  -- -- --

        // 06,04 [02,10]            -- -- -- -- -- -- -- -- --
        // 07,03 [04,10]                  -- -- -- -- -- -- --
        // 08,01 [07,09]                           -- -- --
        // 09,01 [08,10]                              -- -- --

        // 10,01 [09,11]                                 -- -- --
        // 11,02 [09,13]                                 -- -- -- -- --
        // 12,01 [11,13]                                       -- -- --
        // 13,04 [09,17]                                 -- -- -- -- -- -- -- -- --

        // 15,03 [12,18]                                          -- -- -- -- -- -- --
        // 17,03 [14,20]                                                -- -- -- -- -- -- --
    }
}