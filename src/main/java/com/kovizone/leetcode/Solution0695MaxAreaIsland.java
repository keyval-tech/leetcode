package com.kovizone.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/max-area-of-island/">695. 岛屿的最大面积</a>
 *
 * @author KV
 * @since 2022/07/12
 */
public class Solution0695MaxAreaIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, maxAreaOfIsland(grid, i, j));
                }
            }
        }
        return max;
    }

    public int maxAreaOfIsland2(int[][] grid) {
        int ans = 0;
        for (int i = 0; i != grid.length; ++i) {
            for (int j = 0; j != grid[0].length; ++j) {
                int cur = 0;
                Deque<Integer> stackI = new LinkedList<>();
                Deque<Integer> stackJ = new LinkedList<>();
                stackI.push(i);
                stackJ.push(j);
                while (!stackI.isEmpty()) {
                    int curI = stackI.pop();
                    int curJ = stackJ.pop();
                    if (curI < 0 || curJ < 0 || curI == grid.length || curJ == grid[0].length || grid[curI][curJ] != 1) {
                        continue;
                    }
                    ++cur;
                    grid[curI][curJ] = 0;

                    stackI.push(curI);
                    stackI.push(curI);
                    stackI.push(curI + 1);
                    stackI.push(curI - 1);

                    stackJ.push(curJ + 1);
                    stackJ.push(curJ - 1);
                    stackJ.push(curJ);
                    stackJ.push(curJ);
                }
                ans = Math.max(ans, cur);
            }
        }
        return ans;
    }

    public int maxAreaOfIsland(int[][] grid, int r, int c) {
        if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
            grid[r][c] = 0;
            return 1 + maxAreaOfIsland(grid, r + 1, c)
                    + maxAreaOfIsland(grid, r - 1, c)
                    + maxAreaOfIsland(grid, r, c + 1)
                    + maxAreaOfIsland(grid, r, c - 1);
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
