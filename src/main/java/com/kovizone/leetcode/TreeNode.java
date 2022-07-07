package com.kovizone.leetcode;

import lombok.Data;

/**
 * TreeNode
 *
 * @author KV
 * @since 2022/06/22
 */
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
