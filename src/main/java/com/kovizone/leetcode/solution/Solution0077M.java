package com.kovizone.leetcode.solution;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combinations/">77. 组合</a>
 * <p>
 * #回溯
 *
 * @author KV
 * @since 2022/07/28
 */
public class Solution0077M {

    static int NUM = 0;

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> nodeList = new ArrayList<>();
        combine(nodeList, n, k, 0, new ArrayList<>());
        return nodeList;
    }

    public void combine(List<List<Integer>> nodeList, int n, int length, int offset, List<Integer> prefix) {
        int num = NUM;
        NUM++;
        System.out.println(StrUtil.format("【{}】n: {}, length: {}, offset: {}, prefix: {}", num, n, length, offset, prefix));
        if ((n - offset) == length) {
            List<Integer> node = new ArrayList<>(prefix);
            for (int i = 1 + offset; i <= n; i++) {
                node.add(i);
            }
            nodeList.add(node);
        } else if (length == 1) {
            for (int i = 1 + offset; i <= n; i++) {
                List<Integer> node = new ArrayList<>(prefix);
                node.add(i);
                nodeList.add(node);
            }
        } else {
            for (int i = 1 + offset; i <= (n - length + 1); i++) {
                List<Integer> newPrefix = new ArrayList<>(prefix);
                newPrefix.add(i);
                System.out.println("【" + num + " -> " + NUM + "】");
                combine(nodeList, n, length - 1, i, newPrefix);
            }
        }
        System.out.println(StrUtil.format("【{}】return: {}", num, nodeList));
    }

    public static void main(String[] args) {
        System.out.println("result: " + JSONUtil.toJsonStr(new Solution0077M().combine(9, 8)));
    }
}
