package com.kovizone.leetcode.page07;

import cn.hutool.json.JSONUtil;

/**
 * <a href="https://leetcode.cn/problems/flood-fill/">733. 图像渲染</a>
 *
 * @author KV
 * @since 2022/07/11
 */
public class Solution0733FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] != color) {
            floodFill(image, sr, sc, image[sr][sc], color);
        }
        return image;
    }

    public void floodFill(int[][] image, int sr, int sc, final int sourceColor, final int newColor) {
        if (sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length && image[sr][sc] == sourceColor) {
            image[sr][sc] = newColor;
            floodFill(image, sr - 1, sc, sourceColor, newColor);
            floodFill(image, sr + 1, sc, sourceColor, newColor);
            floodFill(image, sr, sc - 1, sourceColor, newColor);
            floodFill(image, sr, sc + 1, sourceColor, newColor);
        }
    }

    public static void main(String[] args) {
        int[][] image = new int[][]{
                new int[]{0, 2, 0},
                new int[]{0, 0, 0},
        };
        for (int[] ints : image) {
            System.out.println(JSONUtil.toJsonStr(ints));
        }

        System.out.println();

        image = new Solution0733FloodFill().floodFill(image, 0, 0, 1);
        for (int[] ints : image) {
            System.out.println(JSONUtil.toJsonStr(ints));
        }
    }
}
