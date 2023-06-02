package com.kovizone.leetcode.solution;

import cn.hutool.core.util.ArrayUtil;

/**
 * <a href="https://leetcode.cn/problems/game-of-life/">289. 生命游戏</a>
 * <p>
 * #数组 #矩阵 #模拟 #中等 #面试经典150题
 *
 * @author KV
 * @since 2023/06/02
 */
public class Solution0289M {
    public void gameOfLife(int[][] board) {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                int survivalSize = survivalSize(board, x, y);
                if (board[x][y] == 1) {
                    if (survivalSize < 2 || survivalSize > 3) {
                        board[x][y] = 2;
                    }
                }
                if (board[x][y] == 0 && survivalSize == 3) {
                    board[x][y] = 3;
                }
            }
        }

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] > 1) {
                    board[x][y] -= 2;
                }
            }
        }
    }

    private int survivalSize(int[][] board, int x, int y) {
        int res = 0;
        // 左上
        res += isSurvival(board, x - 1, y - 1) ? 1 : 0;
        // 右上
        res += isSurvival(board, x - 1, y + 1) ? 1 : 0;
        // 左下
        res += isSurvival(board, x + 1, y - 1) ? 1 : 0;
        // 右下
        res += isSurvival(board, x + 1, y + 1) ? 1 : 0;
        // 上
        res += isSurvival(board, x - 1, y) ? 1 : 0;
        // 下
        res += isSurvival(board, x + 1, y) ? 1 : 0;
        // 左
        res += isSurvival(board, x, y - 1) ? 1 : 0;
        // 右
        res += isSurvival(board, x, y + 1) ? 1 : 0;
        return res;
    }

    private boolean isSurvival(int[][] board, int x, int y) {
        if (x < 0 || x >= board.length) {
            return false;
        }
        if (y < 0 || y >= board[x].length) {
            return false;
        }
        return board[x][y] == 1 || board[x][y] == 2;
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{
                new int[]{0, 1, 0},
                new int[]{0, 0, 1},
                new int[]{1, 1, 1},
                new int[]{0, 0, 0},
        };

        new Solution0289M().gameOfLife(board);

        for (int[] line : board) {
            System.out.println(ArrayUtil.toString(line));
        }
    }
}
