package com.kovizone.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/permutation-in-string/">567. 字符串的排列</a>
 *
 * @author KV
 * @since 2022/07/07
 */
public class Solution0567PermutationString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] c1 = new int[26];
        int[] c2 = new int[26];

        int l1 = s1.length();
        for (int i = 0; i < l1; i++) {
            c1[s1.charAt(i) - 'a']++;
            c2[s2.charAt(i) - 'a']++;
        }
        int right = l1;
        boolean result = Arrays.equals(c1, c2);
        while (right < s2.length() && !result) {
            c2[s2.charAt(right - l1) - 'a']--;
            c2[s2.charAt(right++) - 'a']++;
            result = Arrays.equals(c1, c2);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0567PermutationString().checkInclusion("ab", "eidbaooo"));
    }
}
