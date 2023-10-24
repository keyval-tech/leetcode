package com.kovizone.leetcode.solution;

import com.kovizone.leetcode.core.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">105. 从前序与中序遍历序列构造二叉树</a>
 * <p>
 * #树 #数组 #哈希表 #分治 #二叉树 #中等 #面试经典150题
 *
 * @author KV
 * @since 2023/06/06
 */
public class Solution0105M {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> preorderMap = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) {
            preorderMap.put(preorder[i], i);
        }
        return buildTree(preorderMap, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(Map<Integer, Integer> preorderMap, int[] inorder, int l, int r) {
        if (l < 0 || r >= inorder.length || l > r) {
            return null;
        }
        if (l == r){
            TreeNode treeNode = new TreeNode();
            treeNode.val = inorder[l];
            return treeNode;
        }

        int minPreorderIndex = Integer.MAX_VALUE;
        int rootIndex = -1;
        for (int i = l; i <= r; i++) {
            Integer preorderIndex = preorderMap.get(inorder[i]);
            if (preorderIndex < minPreorderIndex) {
                minPreorderIndex = preorderIndex;
                rootIndex = i;
            }
        }

        TreeNode treeNode = new TreeNode();
        treeNode.val = inorder[rootIndex];
        treeNode.left = buildTree(preorderMap, inorder, l, rootIndex - 1);
        treeNode.right = buildTree(preorderMap, inorder, rootIndex + 1, r);
        return treeNode;
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        Map<Integer, Integer> preorderMap = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) {
            preorderMap.put(preorder[i], i);
        }
        return buildTree1(preorderMap, inorder, 0, inorder.length);
    }

    private TreeNode buildTree1(Map<Integer, Integer> preorderMap, int[] inorder, int l, int r) {
        System.out.println("l: " + l + ", r: " + r);
        if (l >= r || l < 0 || r > inorder.length) {
            System.out.println("无");
            return null;
        }
        if (l == r - 1) {
            TreeNode treeNode = new TreeNode();
            treeNode.val = inorder[l];
            System.out.println("终节点：" + inorder[l]);
            return treeNode;
        }

        int root = -1;
        int minIndex = Integer.MAX_VALUE;
        for (int j = l; j < r; j++) {
            int index = preorderMap.get(inorder[j]);
            if (index < minIndex) {
                root = j;
                minIndex = index;
            }
        }
        System.out.println("根索引：" + root);

        TreeNode treeNode = new TreeNode();
        treeNode.val = inorder[root];
        System.out.println("根节点：" + inorder[root]);
        treeNode.left = buildTree(preorderMap, inorder, l, root);
        treeNode.right = buildTree(preorderMap, inorder, root + 1, r);
        return treeNode;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new Solution0105M().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(treeNode);
    }
}
