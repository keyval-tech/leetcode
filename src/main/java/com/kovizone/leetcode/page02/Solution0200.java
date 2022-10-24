package com.kovizone.leetcode.page02;

/**
 * <a href="https://leetcode.cn/problems/number-of-islands/">200. 岛屿数量</a>
 *
 * @author KV
 * @since 2022/08/15
 */
public class Solution0200 {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == '0') {
                    clear(grid, r, c);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void clear(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        clear(grid, r - 1, c);
        clear(grid, r + 1, c);
        clear(grid, r, c - 1);
        clear(grid, r, c + 1);
    }
}
