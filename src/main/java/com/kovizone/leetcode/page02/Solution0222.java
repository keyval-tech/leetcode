package com.kovizone.leetcode.page02;

import com.kovizone.leetcode.core.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/count-complete-tree-nodes/">222. 完全二叉树的节点个数</a>
 *
 * @author KV
 * @since 2023/02/03
 */
public class Solution0222 {
    public int countNodes(TreeNode root) {
        int height = treeHeight(root);
        if (height <= 1) {
            return height;
        }
        if (treeHeight(root.right) == height - 1) {
            return countNodes(root.right) + (1 << (height - 1));
        }
        return countNodes(root.left) + (1 << (height - 2));
    }

    private int treeHeight(TreeNode root) {
        return root == null ? 0 : 1 + treeHeight(root.left);
    }
}
