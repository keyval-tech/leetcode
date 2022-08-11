package com.kovizone.leetcode.page00;

/**
 * <a href="https://leetcode.cn/problems/sqrtx/">69. x 的平方根 </a>
 *
 * @author KV
 * @since 2022/08/08
 */
public class Solution0069SqrtX {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        return mySqrt(x, 0, x);
    }

    public int mySqrt(int x, int min, int max) {
        if (min >= max) {
            return min - 1;
        }

        int c = (max - min) / 2 + min;
        long sqrtC = (long) c * c;
        System.out.printf("x: %d, min: %d, max: %d, c: %d, sqrtC: %d%n", x, min, max, c, sqrtC);
        if (sqrtC == x) {
            return c;
        }
        if (sqrtC > x || sqrtC < 0) {
            return mySqrt(x, min, c);
        } else {
            return mySqrt(x, c + 1, max);
        }
    }

    public static void main(String[] args) {
        int num = 2147395599;
        System.out.println(new Solution0069SqrtX().mySqrt(num));
        System.out.println(Math.pow(num, 0.5));
    }
}
