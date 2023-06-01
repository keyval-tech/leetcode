package com.kovizone.leetcode.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/valid-sudoku/">36. 有效的数独</a>
 * <p>
 * #数组 #哈希表 #矩阵 #中等 #面试经典150题
 *
 * @author KV
 * @since 2023/06/01
 */
public class Solution0036M {

    public static void main(String[] args) {

        // ["5","3",".",".","7",".",".",".","."],
        // ["6",".",".","1","9","5",".",".","."],
        // [".","9","8",".",".",".",".","6","."],
        // ["8",".",".",".","6",".",".",".","3"],
        // ["4",".",".","8",".","3",".",".","1"],
        // ["7",".",".",".","2",".",".",".","6"],
        // [".","6",".",".",".",".","2","8","."],
        // [".",".",".","4","1","9",".",".","5"],
        // [".",".",".",".","8",".",".","7","9"]

        System.out.println(new Solution0036M().isValidSudoku(new char[][]{
                new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
    }

    public boolean isValidSudoku(char[][] board) {
        int[][] xCheck = new int[9][9];
        int[][] yCheck = new int[9][9];
        int[][][] blockCheck = new int[3][3][9];

        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                char c = board[x][y];
                if (c != '.') {
                    int i = c - '1';
                    xCheck[x][i]++;
                    yCheck[y][i]++;
                    blockCheck[x / 3][y / 3][i]++;
                    if (xCheck[x][i] > 1 || yCheck[y][i] > 1 || blockCheck[x / 3][y / 3][i] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        Map<Integer, Set<Character>> yCheckMap = new HashMap<>();
        Map<Integer, Set<Character>> blockCheckMap = new HashMap<>();

        for (int x = 0; x < 9; x++) {
            Set<Character> xCheck = new HashSet<>();
            for (int y = 0; y < 9; y++) {
                char c = board[x][y];
                if (c != '.') {
                    if (xCheck.contains(c)) {
                        return false;
                    }
                    xCheck.add(c);

                    Set<Character> yCheck = yCheckMap.computeIfAbsent(y, k -> new HashSet<>());
                    if (yCheck.contains(c)) {
                        return false;
                    }
                    yCheck.add(c);

                    Set<Character> blackCheck = blockCheckMap.computeIfAbsent(block(x, y), k -> new HashSet<>());
                    if (blackCheck.contains(c)) {
                        return false;
                    }
                    blackCheck.add(c);
                }
            }
        }
        return true;
    }

    private int block(int x, int y) {
        if (x >= 0 && x <= 2 && y >= 0 && y <= 2) {
            return 0;
        }
        if (x >= 3 && x <= 5 && y >= 0 && y <= 2) {
            return 1;
        }
        if (x >= 6 && x <= 8 && y >= 0 && y <= 2) {
            return 2;
        }
        if (x >= 0 && x <= 2 && y >= 2 && y <= 5) {
            return 3;
        }
        if (x >= 3 && x <= 5 && y >= 2 && y <= 5) {
            return 4;
        }
        if (x >= 6 && x <= 8 && y >= 2 && y <= 5) {
            return 5;
        }
        if (x >= 0 && x <= 2 && y >= 6 && y <= 8) {
            return 6;
        }
        if (x >= 3 && x <= 5 && y >= 6 && y <= 8) {
            return 7;
        }
        return 8;
    }

    public boolean isValidSudoku1(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (isRepeat(board, i, 0, i, 8)) {
                return false;
            }
            if (isRepeat(board, 0, i, 8, i)) {
                return false;
            }
        }

        return !(isRepeat(board, 0, 0, 2, 2)
                || isRepeat(board, 3, 0, 5, 2)
                || isRepeat(board, 6, 0, 8, 2)
                || isRepeat(board, 0, 3, 2, 5)
                || isRepeat(board, 3, 3, 5, 5)
                || isRepeat(board, 6, 3, 8, 5)
                || isRepeat(board, 0, 6, 2, 8)
                || isRepeat(board, 3, 6, 5, 8)
                || isRepeat(board, 6, 6, 8, 8));
    }

    private boolean isRepeat(char[][] board, int x1, int y1, int x2, int y2) {
        Set<Character> set = new HashSet<>();
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                if (board[x][y] != '.') {
                    if (set.contains(board[x][y])) {
                        return true;
                    }
                    set.add(board[x][y]);
                }
            }
        }
        return false;
    }
}
