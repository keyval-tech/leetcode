package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/integer-break/">343. 整数拆分</a>
 *
 * @author KV
 * @since 2023/02/06
 */
public class Solution0343 {
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }

        switch (n % 3) {
            case 1:
                return (int) Math.pow(3, n / 3 - 1) * 4;
            case 2:
                return (int) Math.pow(3, n / 3) * 2;
            default:
                return (int) Math.pow(3, n / 3);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution0343().integerBreak(2));
        System.out.println(new Solution0343().integerBreak(3));
        System.out.println(new Solution0343().integerBreak(4));
        System.out.println(new Solution0343().integerBreak(5));
        System.out.println(new Solution0343().integerBreak(6));
        System.out.println(new Solution0343().integerBreak(7));
        System.out.println(new Solution0343().integerBreak(8));
    }
}
