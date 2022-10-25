package com.kovizone.leetcode.page00;

/**
 * <a href="https://leetcode.cn/problems/unique-paths/">62. 不同路径</a>
 *
 * @author KV
 * @since 2022/10/24
 */
public class Solution0062 {

    public int uniquePaths(int m, int n) {
        int[][] board = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = (i == 0 || j == 0) ? 1 : (board[i - 1][j] + board[i][j - 1]);
            }
        }
        return board[m - 1][n - 1];
    }

    public int uniquePaths1(int m, int n) {
        if (m > n) {
            return uniquePaths1(n, m);
        }
        if (m == 1) {
            return 1;
        }
        if (m == 2) {
            return n;
        }
        if (m == n) {
            return uniquePaths1(m - 1, n) * 2;
        }
        return uniquePaths1(m - 1, n) + uniquePaths1(m, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution0062().uniquePaths(4, 4));
    }
}
