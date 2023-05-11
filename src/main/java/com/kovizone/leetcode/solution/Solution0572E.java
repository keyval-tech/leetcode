package com.kovizone.leetcode.solution;

import com.kovizone.leetcode.core.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/subtree-of-another-tree/">572. 另一棵树的子树</a>
 * <p>
 * #树 #深度优先搜索 #二叉树 #字符串匹配 #哈希函数 #简单
 *
 * @author KV
 * @since 2022/08/17
 */
public class Solution0572E {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return false;
        }
        return check(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean check(TreeNode root, TreeNode subRoot) {
        System.out.println();
        System.out.println("root: " + root);
        System.out.println("subRoot: " + subRoot);
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }
        return check(root.left, subRoot.left) && check(root.right, subRoot.right);
    }

    public static void main(String[] args) {
        System.out.println(new Solution0572E().isSubtree(
                TreeNode.parse(
                        1,
                        0, 1,
                        0, 1, 0, 1,
                        0, 1, 0, 1, 0, 1, 0, 1,
                        0, 1, 0, 1, 0, 1, 2),
                TreeNode.parse(
                        1,
                        0, 1,
                        0, 1, 0, 1,
                        0, 1, 0, 1, 2)
        ));
    }
}