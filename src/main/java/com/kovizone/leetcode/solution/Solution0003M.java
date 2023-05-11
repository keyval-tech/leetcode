package com.kovizone.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">3. 无重复字符的最长子串</a>
 * <p>
 * #哈希表 #字符串 #滑动窗口 #中等
 *
 * @author KV
 * @since 2022/07/07
 */
public class Solution0003M {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int l = s.length();
        int right = 0;
        for (int left = 0; left < l; left++) {
            if (left > 0) {
                set.remove(s.charAt(left - 1));
            }
            while (right < l && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
            }
            System.out.println(set);
            max = Math.max(max, right - left);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0003M().lengthOfLongestSubstring("pwwkew"));
    }
}
