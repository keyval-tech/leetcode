package com.kovizone.leetcode.core;

import cn.hutool.core.collection.CollUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Node
 *
 * @author KV
 * @since 2022/07/12
 */
public class Node {
    /**
     * 节点值
     */
    public int val;
    /**
     * 左子节点
     */
    public Node left;
    /**
     * 右子节点
     */
    public Node right;
    /**
     * 右侧节点
     */
    public Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    public static Node parse(Integer... values) {

        // 最大层数
        int maxLay = BigDecimal.valueOf(Math.log(values.length + 1) / Math.log(2)).setScale(0, RoundingMode.CEILING).intValue();
        Node[][] nodeGrip = new Node[maxLay][(int) Math.pow(2, maxLay - 1)];
        int j = 0;
        for (int l = 0; l < maxLay && j < values.length; l++) {
            int size = (int) Math.pow(2, l);
            nodeGrip[l] = new Node[size];
            for (int i = 0; i < size && j < values.length; i++) {
                Integer value = values[j++];
                if (value != null) {
                    nodeGrip[l][i] = new Node(value);
                } else {
                    nodeGrip[l][i] = new Node();
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

    public String toLineString() {
        return "[" + val + "]" + (next == null ? "" : " -> " + next.toLineString());
    }

    @Override
    public String toString() {
        Deque<Node> nodeDeque = CollUtil.newLinkedList(this);
        List<List<String>> nodeGrip = new ArrayList<>();
        while (!nodeDeque.isEmpty()) {
            List<String> nodeList = new ArrayList<>();
            boolean allNull = true;
            int size = nodeDeque.size();
            for (int i = 0; i < size; i++) {
                Node node = nodeDeque.pollFirst();
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
        if (next != null) {
            stringBuilder.append(",\"next\":").append(next.val);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
