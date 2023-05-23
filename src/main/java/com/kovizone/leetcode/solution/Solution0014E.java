package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/longest-common-prefix/">14. 最长公共前缀</a>
 * <p>
 * #字典树 #字符串 #简单 #面试经典150题
 *
 * @author KV
 * @since 2023/05/23
 */
public class Solution0014E {
    public String longestCommonPrefix(String[] strs) {
        int r = 0;
        while (true) {
            for (String str : strs) {
                if (r >= str.length() || str.charAt(r) != strs[0].charAt(r)) {
                    return str.substring(0, r);
                }
            }
            r++;
        }
    }
}
