package com.kovizone.leetcode.page00;

/**
 * <a href="https://leetcode.cn/problems/word-search/">79. 单词搜索</a>
 *
 * @author KV
 * @since 2022/10/24
 */
public class Solution0079 {
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        boolean[][] vis = new boolean[board.length][board[0].length];
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (exist(board, chars, 0, x, y, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    int[] offsetX = {+1, +0, +0, -1};
    int[] offsetY = {+0, +1, -1, +0};

    public boolean exist(char[][] board,
                         char[] chars,
                         int idx,
                         int x,
                         int y,
                         boolean[][] vis) {
        if (idx == chars.length) {
            return true;
        }
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || vis[x][y] || board[x][y] != chars[idx]) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            vis[x][y] = true;
            if (exist(board, chars, idx + 1, x + offsetX[i], y + offsetY[i], vis)) {
                return true;
            }
            vis[x][y] = false;
        }
        return false;
    }

    public static void main(String[] args) {

        char[][] board = new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
                new char[]{'A', 'D', 'E', 'F'}
        };

        String word = "ABCCED";

        System.out.println(new Solution0079().exist(board, word));
    }
}