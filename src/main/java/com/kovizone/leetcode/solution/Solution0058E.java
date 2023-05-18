package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/length-of-last-word/">58. 最后一个单词的长度</a>
 * <p>
 * #字符串 #简单 #面试经典150题
 *
 * @author KV
 * @since 2023/05/18
 */
public class Solution0058E {
    public int lengthOfLastWord(String s) {
        int r = s.length() - 1;
        while (s.charAt(r) == ' ') {
            r--;
        }
        int res = 0;
        while (r - res >= 0 && s.charAt(r - res) != ' ') {
            res++;
        }
        return res;
    }

    public int lengthOfLastWord2(String s) {
        s = " " + s.trim();
        return s.length() - s.lastIndexOf(' ') - 1;
    }
}
