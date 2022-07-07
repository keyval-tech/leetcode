package com.kovizone.leetcode;

/**
 * <a href="https://leetcode.cn/problems/reverse-string/">344. 反转字符串</a>
 *
 * @author KV
 * @since 2022/07/07
 */
public class Solution0344ReverseString {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char t = s[l];
            s[l++] = s[r];
            s[r--] = t;
        }
    }
}
