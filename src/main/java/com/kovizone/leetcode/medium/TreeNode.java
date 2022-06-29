package com.kovizone.leetcode.medium;

import lombok.Data;

/**
 * TreeNode
 *
 * @author KV
 * @since 2022/06/22
 */
@Data
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
