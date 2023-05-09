package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/longest-palindromic-substring/">5. 最长回文子串</a>
 *
 * @author KV
 * @since 2022/10/25
 */
public class Solution0005 {
    public String longestPalindrome(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int maxL = 0;
        int maxR = 0;
        for (int i = 0; i < n - 1; i++) {
            int l = i;
            int r = i;
            // 回文中心都是一样的符号
            while (r < n - 1 && chars[r + 1] == chars[r]) {
                i++;
                r++;
            }
            // 两边扩散
            while (l > 0 && r < n - 1 && chars[l - 1] == chars[r + 1]) {
                l--;
                r++;
            }
            // (r + 1 - l) > (maxR + 1 - maxL) 缩写
            if ((r - l) > (maxR - maxL)) {
                maxL = l;
                maxR = r;
            }
        }
        return s.substring(maxL, maxR + 1);
    }


    public static void main(String[] args) {
        System.out.println(new Solution0005().longestPalindrome("a"));
    }
}
