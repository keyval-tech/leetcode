package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/reverse-words-in-a-string/">151. 反转字符串中的单词</a>
 * <p>
 * #双指针 #字符串 #中等 #面试经典150题
 *
 * @author KV
 * @see Solution0344E
 * @since 2023/05/23
 */
public class Solution0151M {
    public String reverseWords(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int l = 0;
        StringBuilder res = new StringBuilder();
        while (l < n) {
            while (l < n && chars[l] == ' ') {
                l++;
            }
            if (l >= n) {
                break;
            }
            int r = l + 1;
            while (r < n && chars[r] != ' ') {
                r++;
            }
            res.insert(0, " " + s.substring(l, r));
            l = r + 1;
        }
        return res.substring(1);
    }

    public static void main(String[] args) {
        System.out.println("|" + new Solution0151M().reverseWords("  the sky    is blue  ") + "|");
    }
}
