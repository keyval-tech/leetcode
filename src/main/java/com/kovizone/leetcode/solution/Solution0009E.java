package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/palindrome-number/">9. 回文数</a>
 * <p>
 * #数学 #简单 #面试经典150题
 *
 * @author KV
 * @since 2023/06/07
 */
public class Solution0009E {

    private static final int[] X = new int[]{
            1,
            10,
            100,
            1000,
            10000,
            100000,
            1000000,
            10000000,
            100000000,
            1000000000};

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int l = 0;
        int r = (int) Math.log10(x);
        while (l < r) {
            if ((x / X[l] % 10) != x / X[r] % 10) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
