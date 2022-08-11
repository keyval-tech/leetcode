package com.kovizone.leetcode.page01;

import cn.hutool.core.collection.CollUtil;

import java.util.List;

/**
 * Solution0120Triangle
 *
 * @author KV
 * @since 2022/08/04
 */
public class Solution0120Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        // TODO 待优化
        for (int i = triangle.size() - 1; i > 0; i--) {
            List<Integer> row = triangle.get(i);
            List<Integer> preRow = triangle.get(i - 1);
            for (int j = 0; j < preRow.size(); j++) {
                preRow.set(j, preRow.get(j) + Math.min(row.get(j), row.get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        System.out.println(new Solution0120Triangle().minimumTotal(
                CollUtil.newArrayList(
                        CollUtil.newArrayList(2),
                        CollUtil.newArrayList(3, 4),
                        CollUtil.newArrayList(6, 5, 7),
                        CollUtil.newArrayList(4, 1, 8, 3)
                )
        ));
    }
}
