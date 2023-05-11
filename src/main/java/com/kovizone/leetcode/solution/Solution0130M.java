package com.kovizone.leetcode.solution;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/surrounded-regions/">130. 被围绕的区域</a>
 * <p>
 * #深度优先搜索 #广度优先搜索 #并查集 #数组 #矩阵 #中等
 *
 * @author KV
 * @since 2022/08/23
 */
public class Solution0130M {

    public void solve(char[][] board) {
        int rowLength = board.length;
        int cellLength = board[0].length;
        if (rowLength <= 2 || cellLength <= 2) {
            return;
        }

        // 遍历周围一圈
        for (int r = 0; r < rowLength; r++) {
            if (r == 0 || r == rowLength - 1) {
                for (int c = 0; c < board[r].length; c++) {
                    sdf(board, r, c);
                }
            } else {
                sdf(board, r, 0);
                sdf(board, r, cellLength - 1);
            }
        }

        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
        System.out.println();
    }

    private void sdf(final char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[r].length || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'T';
        sdf(board, r + 1, c);
        sdf(board, r - 1, c);
        sdf(board, r, c + 1);
        sdf(board, r, c - 1);
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'O', 'O', 'X'}
        };

        for (char[] value : board) {
            System.out.println(Arrays.toString(value));
        }
        System.out.println();
        new Solution0130M().solve(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
        System.out.println();
    }
}
