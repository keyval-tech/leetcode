package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/reverse-string/">344. 反转字符串</a>
 * <p>
 * #双指针 #字符串 #简单
 *
 * @author KV
 * @see Solution0151M
 * @since 2022/07/07
 */
public class Solution0344E {
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
