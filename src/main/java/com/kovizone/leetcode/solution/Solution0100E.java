package com.kovizone.leetcode.solution;

import com.kovizone.leetcode.core.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/same-tree/">100. 相同的树</a>
 * <p>
 * #树 #深度优先搜索 #广度优先搜索 #二叉树 #简单 #面试经典150题
 *
 * @author KV
 * @since 2023/06/06
 */
public class Solution0100E {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        return p != null && q != null && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}