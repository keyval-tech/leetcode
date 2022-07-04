package com.kovizone.leetcode.solution;

import com.kovizone.leetcode.bean.TreeNode;

/**
 * 513
 * <a href="https://leetcode.cn/problems/find-bottom-left-tree-value/">513. 找树左下角的值</a>
 *
 * @author KV
 */
public class S0513FindBottomLeftValueSolution {

    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValue(root, 1);
        return maxVal;
    }

    int maxDepth = 0;
    int maxVal = 0;

    public void findBottomLeftValue(TreeNode root, int currentDepth) {
        if (root != null) {
            if (currentDepth > maxDepth) {
                maxDepth = currentDepth;
                maxVal = root.val;
            }
            if (root.left != null) {
                findBottomLeftValue(root.left, currentDepth + 1);
            }
            if (root.right != null) {
                findBottomLeftValue(root.right, currentDepth + 1);
            }
        }
    }
}
