package com.kovizone.leetcode.page00;

/**
 * <a href="https://leetcode.cn/problems/decode-ways/">91. 解码方法</a>
 *
 * @author KV
 * @since 2022/10/25
 */
public class Solution0091 {
    public int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            // 单独解码s[i - 1]
            if (s.charAt(i - 1) != '0') {
                f[i] = f[i - 1];
            }
            if (i >= 2) {
                int t = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
                // 将s[i - 2] 和 s[i - 1]组合解码
                if (t >= 10 && t <= 26) {
                    f[i] += f[i - 2];
                }
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution0091().numDecodings("1111010101020"));
        //    [1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 2, 0]
        // [1, 1, 2, 3, 5, 3, 3, 3, 3, 3, 3, 3, 3, 3]
    }
}
