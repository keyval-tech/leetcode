package com.kovizone.leetcode.solution;

import com.kovizone.leetcode.core.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/">104. 二叉树的最大深度</a>
 * <p>
 * #树 #深度优先搜索 #广度优先搜索 #二叉树 #简单 #面试经典150题
 *
 * @author KV
 * @since 2023/06/06
 */
public class Solution0104E {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : (1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
    }
}
