package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/is-subsequence/">392. 判断子序列</a>
 * <p>
 * #双指针 #字符串 #动态规划 #简单 #面试经典150题
 *
 * @author KV
 * @since 2023/05/31
 */
public class Solution0392E {
    public boolean isSubsequence(String s, String t) {
        int sp = 0;
        int tp = 0;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        while (sp < sChars.length && tp < tChars.length) {
            while (tp < tChars.length && tChars[tp] != sChars[sp]) {
                tp++;
            }
            if (tp == tChars.length) {
                return false;
            }
            if (tChars[tp] == sChars[sp]) {
                sp++;
                tp++;
            }
        }
        return sp == sChars.length;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0392E().isSubsequence("axc", "ahbgdc"));
    }
}
