package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/ransom-note/">383. 赎金信</a>
 * <p>
 * #哈希表 #字符串 #计数 #简单 #面试经典150题
 *
 * @author KV
 * @since 2023/06/05
 */
public class Solution0383E {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] randomNodeChars = ransomNote.toCharArray();
        char[] magazineChars = magazine.toCharArray();

        int[] letters = new int[26];
        for (char magazineChar : magazineChars) {
            letters[magazineChar - 'a']++;
        }
        for (char randomNodeChar : randomNodeChars) {
            if (letters[randomNodeChar - 'a'] == 0) {
                return false;
            }
            letters[randomNodeChar - 'a']--;
        }
        return true;
    }
}
