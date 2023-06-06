package com.kovizone.leetcode.solution;

import com.kovizone.leetcode.core.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/symmetric-tree/">101. 对称二叉树</a>
 * <p>
 * #树 #深度优先搜索 #广度优先搜索 #二叉树 #简单 #面试经典150题
 *
 * @author KV
 * @since 2023/06/06
 */
public class Solution0101E {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }
        return l != null && r != null && l.val == r.val && isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
    }
}
