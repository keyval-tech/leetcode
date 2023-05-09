package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/count-vowel-substrings-of-a-string/">2062. 统计字符串中的元音子字符串</a>
 *
 * @author KV
 * @since 2023/02/08
 */
public class Solution2062 {

    private final static int VOWEL = 1 << ('a' - 'a') | 1 << ('e' - 'a') | 1 << ('i' - 'a') | 1 << ('o' - 'a') | 1 << ('u' - 'a');


    public int countVowelSubstrings(String word) {
        int ans = 0;
        final int n = word.length();

        for (int i = 0; i < n - 4; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                int r = 1 << (word.charAt(j) - 'a');
                if ((VOWEL & r) == 0) {
                    break;
                }
                sum |= r;
                if (sum == VOWEL) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2062().countVowelSubstrings("aeiouu"));
    }
}
