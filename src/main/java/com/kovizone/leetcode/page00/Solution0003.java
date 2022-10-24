package com.kovizone.leetcode.page00;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">3. 无重复字符的最长子串</a>
 *
 * @author KV
 * @since 2022/07/07
 */
public class Solution0003 {
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
        System.out.println(new Solution0003().lengthOfLongestSubstring("pwwkew"));
    }
}
