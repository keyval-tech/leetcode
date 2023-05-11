package com.kovizone.leetcode.solution;

/**
 * <a href="https://leetcode.cn/problems/stamping-the-grid/">2132. 用邮票贴满网格图</a>
 *
 * #贪心 #数组 #矩阵 #前缀和 #困难
 *
 * @author other
 */
public class Solution2132H {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int[][] a = new int[rowLength + 1][colLength + 1];
        //原矩阵往外挪一个位置
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                a[i + 1][j + 1] = grid[i][j];
            }
        }

        System.out.println("a: ");
        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.print(anInt);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();

        //初始化矩阵前缀和
        int[][] aSum = new int[rowLength + 1][colLength + 1];
        for (int i = 1; i <= rowLength; i++) {
            for (int j = 1; j <= colLength; j++) {
                aSum[i][j] = aSum[i - 1][j] + aSum[i][j - 1] - aSum[i - 1][j - 1] + a[i][j];
            }
        }
        //差分矩阵
        int[][] vis = new int[rowLength + 2][colLength + 2];
        for (int i = 1; i <= rowLength; i++) {
            for (int j = 1; j <= colLength; j++) {
                if (a[i][j] == 1) {
                    continue;
                }
                //空位，能放就放
                int x = i + stampHeight - 1, y = j + stampWidth - 1;
                if (x <= rowLength && y <= colLength) {
                    int sum = getSum(aSum, i, j, x, y);
                    //全是空位，可以放邮票，维护差分矩阵
                    if (sum == 0) {
                        vis[i][j] += 1;
                        vis[x + 1][y + 1] += 1;
                        vis[i][y + 1] -= 1;
                        vis[x + 1][j] -= 1;
                    }
                }
            }
        }
        //初始化差分数组矩阵前缀和
        int[][] visSum = new int[rowLength + 2][colLength + 2];
        for (int i = 1; i <= rowLength + 1; i++) {
            for (int j = 1; j <= colLength + 1; j++) {
                visSum[i][j] = visSum[i - 1][j] + visSum[i][j - 1] - visSum[i - 1][j - 1] + vis[i][j];
            }
        }
        //重新遍历一遍数组，看看是否所有点都被邮票覆盖过
        for (int i = 1; i <= rowLength; i++) {
            for (int j = 1; j <= colLength; j++) {
                if (a[i][j] == 0 && visSum[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    //获取左上角[a,b]和右下角[x,y]之间的矩阵区域面积
    public int getSum(int[][] sum, int a, int b, int x, int y) {
        return sum[x][y] + sum[a - 1][b - 1] - sum[x][b - 1] - sum[a - 1][y];
    }

    public static void main(String[] args) {
        new Solution2132H().possibleToStamp(
                new int[][]{
                        new int[]{1, 0, 0, 0},
                        new int[]{1, 0, 0, 0},
                        new int[]{1, 0, 0, 0},
                        new int[]{1, 0, 0, 0},
                },
                4, 3
        );
    }
}
