package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/valid-palindrome/">125. 验证回文串</a>
 * <p>
 * #双指针 #字符串 #简单 #面试经典150题
 *
 * @author KV
 * @since 2023/05/31
 */
public class Solution0125E {

    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while (l < r) {
            while (!sdf(chars[l]) && l < r) {
                l++;
            }
            while (!sdf(chars[r]) && l < r) {
                r--;
            }
            if (lower(chars[l]) != lower(chars[r])) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean sdf(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        return c >= '0' && c <= '9';
    }

    public char lower(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (c - 'A' + 'a');
        }
        return c;
    }

    public static void main(String[] args) {
        char a = 'Z';
        System.out.println((char) (a - 'A' + 'a'));
    }
}
