package com.kovizone.leetcode.page05;

/**
 * <a href="https://leetcode.cn/problems/delete-operation-for-two-strings/">583. 两个字符串的删除操作</a>
 *
 * @author KV
 * @since 2023/02/03
 */
public class Solution0538 {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int x = 1; x < dp.length; x++) {
            dp[x][0] = x;
        }
        for (int y = 1; y < dp[0].length; y++) {
            dp[0][y] = y;
        }

        for (int x = 1; x <= m; x++) {
            char xc = word1.charAt(x - 1);
            for (int y = 1; y <= n; y++) {
                char yc = word2.charAt(y - 1);
                if (xc == yc) {
                    dp[x][y] = dp[x - 1][y - 1];
                } else {
                    dp[x][y] = Math.min(dp[x - 1][y], dp[x][y - 1]) + 1;
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            if (i == 0) {
                System.out.print("    ");
                for (int ii = 0; ii < word2.length(); ii++) {
                    System.out.print(word2.charAt(ii) + " ");
                }
                System.out.println();
                System.out.print("  ");
            } else {
                System.out.print(word1.charAt(i - 1) + " ");
            }


            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        int result = new Solution0538().minDistance("sea", "seat");
        System.out.println();
        System.out.println("result: " + result);
    }


}
