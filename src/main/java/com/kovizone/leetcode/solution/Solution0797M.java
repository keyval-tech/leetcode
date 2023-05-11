package com.kovizone.leetcode.solution;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.json.JSONUtil;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/all-paths-from-source-to-target/">797. 所有可能的路径</a>
 * <p>
 * #深度优先搜索 #广度优先搜索 #图 #回溯 #中等
 *
 * @author KV
 * @since 2022/08/24
 */
public class Solution0797M {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();

        Queue<List<Integer>> queue = new LinkedList<>();
        int[] nums = graph[0];
        for (int num : nums) {
            List<Integer> path = new ArrayList<>();
            path.add(0);
            path.add(num);
            queue.add(path);
        }
        while (!queue.isEmpty()) {
            System.out.println("queue: " + JSONUtil.toJsonStr(queue));
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                List<Integer> path = queue.poll();
                if (path != null) {
                    int lastNodeIndex = path.get(path.size() - 1);
                    // 路径已到达目标
                    if (lastNodeIndex == graph.length - 1) {
                        ans.add(path);
                        System.out.println("ans: " + ans);
                    } else {
                        int[] nextNodeIndexArr = graph[lastNodeIndex];
                        if (nextNodeIndexArr.length > 0) {
                            for (int nextNodeIndex : nextNodeIndexArr) {
                                List<Integer> nextPath = new ArrayList<>(path);
                                nextPath.add(nextNodeIndex);
                                queue.add(nextPath);
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        return allPathsSourceTarget(graph, 0, new ArrayList<>());
    }

    public List<List<Integer>> allPathsSourceTarget(final int[][] graph, int i, List<Integer> prefix) {
        prefix.add(i);
        List<List<Integer>> allPaths = new ArrayList<>();
        if (i == graph.length - 1) {
            allPaths.add(new ArrayList<>(prefix));
            return allPaths;
        }
        if (graph[i].length == 0) {
            return allPaths;
        }

        int[] nextNodeIndexArr = graph[i];
        System.out.println();
        System.out.println("prefix: " + prefix);
        System.out.println(Arrays.toString(nextNodeIndexArr));
        for (int nextNodeIndex : nextNodeIndexArr) {
            ThreadUtil.sleep(1000);
            List<Integer> path = new ArrayList<>(prefix);
            List<List<Integer>> subAllPaths = allPathsSourceTarget(graph, nextNodeIndex, path);
            allPaths.addAll(subAllPaths);
        }
        return allPaths;
    }

    public static void main(String[] args) {
        System.out.println(JSONUtil.toJsonStr(new Solution0797M().allPathsSourceTarget(new int[][]{
                {4, 3, 1},
                {3, 2, 4},
                {3},
                {4},
                {},
        })));
    }
}
