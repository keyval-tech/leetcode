package com.kovizone.leetcode.core;

import cn.hutool.core.collection.CollUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * TreeNode
 *
 * @author KV
 * @since 2022/06/22
 */
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        Deque<TreeNode> nodeDeque = CollUtil.newLinkedList(this);
        List<List<String>> nodeGrip = new ArrayList<>();
        while (!nodeDeque.isEmpty()) {
            List<String> nodeList = new ArrayList<>();
            boolean allNull = true;
            int size = nodeDeque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodeDeque.pollFirst();
                if (node != null) {
                    allNull = false;
                }
                nodeList.add(node == null ? "{}" : node.toSimpleString());
                nodeDeque.addLast(node == null ? null : node.left);
                nodeDeque.addLast(node == null ? null : node.right);
            }
            if (allNull) {
                break;
            }
            nodeGrip.add(nodeList);
        }

        return nodeGrip.toString().replaceAll("(, \\{\\})*\\]\\]", "]]");
    }

    public String toSimpleString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        stringBuilder.append("\"val\":").append(val);
        if (left != null) {
            stringBuilder.append(",\"left\":").append(left.val);
        }
        if (right != null) {
            stringBuilder.append(",\"right\":").append(right.val);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static TreeNode parse(Integer... values) {

        // 最大层数
        int maxLay = BigDecimal.valueOf(Math.log(values.length + 1) / Math.log(2)).setScale(0, RoundingMode.CEILING).intValue();
        TreeNode[][] nodeGrip = new TreeNode[maxLay][(int) Math.pow(2, maxLay - 1)];
        int j = 0;
        for (int l = 0; l < maxLay && j < values.length; l++) {
            int size = (int) Math.pow(2, l);
            nodeGrip[l] = new TreeNode[size];
            for (int i = 0; i < size && j < values.length; i++) {
                Integer value = values[j++];
                if (value != null) {
                    nodeGrip[l][i] = new TreeNode(value);
                } else {
                    nodeGrip[l][i] = new TreeNode();
                }
                if (l > 0) {
                    if (i % 2 == 0) {
                        nodeGrip[l - 1][i / 2].left = nodeGrip[l][i];
                    } else {
                        nodeGrip[l - 1][i / 2].right = nodeGrip[l][i];
                    }
                }
            }
        }
        return nodeGrip[0][0];
    }
}
