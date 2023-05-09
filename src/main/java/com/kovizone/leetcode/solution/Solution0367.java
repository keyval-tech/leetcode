package com.kovizone.leetcode.solution;

import cn.hutool.core.thread.ThreadUtil;

/**
 * <a href="https://leetcode.cn/problems/valid-perfect-square/">367. 有效的完全平方数</a>
 *
 * @author KV
 * @since 2022/08/05
 */
public class Solution0367 {
    public boolean isPerfectSquare(int num) {
        return isPerfectSquare(num, 0, num);
    }

    public boolean isPerfectSquare(long num, long min, long max) {
        ThreadUtil.sleep(500);
        long c = (max - min) / 2 + min;
        long cSquare = c * c;
        System.out.printf("num: %d, min: %d, max: %d, c: %d, cSquare: %d%n", num, min, max, c, cSquare);
        if (cSquare == num) {
            return true;
        }
        if (min >= max) {
            return false;
        }
        if (cSquare > num) {
            return isPerfectSquare(num, min, c - 1);
        } else {
            return isPerfectSquare(num, c + 1, max);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution0367().isPerfectSquare(14));
    }
}
