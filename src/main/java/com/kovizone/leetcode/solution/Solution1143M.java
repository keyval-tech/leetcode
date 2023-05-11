package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/longest-common-subsequence/">1143. 最长公共子序列</a>
 * <p>
 * #广度优先搜索 #数组 #矩阵 #中等
 *
 * @author KV
 * @since 2023/02/01
 */
public class Solution1143M {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int x = 1; x < m + 1; x++) {
            char xc = text1.charAt(x - 1);
            for (int y = 1; y < n + 1; y++) {
                char yc = text2.charAt(y - 1);
                if (xc == yc) {
                    dp[x][y] = dp[x - 1][y - 1] + 1;
                } else {
                    dp[x][y] = Math.max(dp[x - 1][y], dp[x][y - 1]);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            if (i == 0) {
                System.out.print("    ");
                for (int ii = 0; ii < text2.length(); ii++) {
                    System.out.print(text2.charAt(ii) + " ");
                }
                System.out.println();
                System.out.print("  ");
            } else {
                System.out.print(text1.charAt(i - 1) + " ");
            }


            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        int result = new Solution1143M().longestCommonSubsequence("bsbininm", "jmjkbkjkv");

        System.out.println();
        System.out.println("result: " + result);
    }
}
