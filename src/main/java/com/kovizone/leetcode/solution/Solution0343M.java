package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/integer-break/">343. 整数拆分</a>
 *
 * #数学 #动态规划 #中等
 *
 * @author KV
 * @since 2023/02/06
 */
public class Solution0343M {
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
        System.out.println(new Solution0343M().integerBreak(2));
        System.out.println(new Solution0343M().integerBreak(3));
        System.out.println(new Solution0343M().integerBreak(4));
        System.out.println(new Solution0343M().integerBreak(5));
        System.out.println(new Solution0343M().integerBreak(6));
        System.out.println(new Solution0343M().integerBreak(7));
        System.out.println(new Solution0343M().integerBreak(8));
    }
}
