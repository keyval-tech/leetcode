package com.kovizone.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/max-points-on-a-line/">149. 直线上最多的点数</a>
 *
 * @author KV
 * @since 2023/02/07
 */
public class Solution0149 {
    public int maxPoints(int[][] points) {
        int n = points.length;

        int ans = 1;

        for (int i = 0; i < n; i++) {

            int x = points[i][0];
            int y = points[i][1];

            int max = 0;

            Map<String, Integer> counts = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                // 求两坐标x的差和y的差
                int difX = x - points[j][0];
                int difY = y - points[j][1];

                // 求最大公约数
                int gcd = gcd(difX, difY);
                String key = (difX / gcd) + "_" + (difY / gcd);

                counts.merge(key, 1, Integer::sum);
                max = Math.max(max, counts.get(key));
            }

            ans = Math.max(ans, max + 1);
        }

        return ans;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(new Solution0149().maxPoints(
                new int[][]{
                        new int[]{1, 1},
                        new int[]{2, 2},
                        new int[]{3, 3}
                }
        ));
    }
}
