package com.kovizone.leetcode.solution;

import com.kovizone.leetcode.core.Node;

import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/">116. 填充每个节点的下一个右侧节点指针</a>
 * <p>
 * #树 #深度优先搜索 #广度优先搜索 #链表 #二叉树 #中等
 *
 * @author KV
 * @see Solution0117M
 * @since 2022/07/12
 */
public class Solution0116M {
    public Node connect(Node root) {
        dis(root);
        return root;
    }

    public void dis(Node node) {
        if (node != null) {
            link(node.left, node.right);
            dis(node.left);
            dis(node.right);
        }
    }

    public void link(Node node1, Node node2) {
        if (node1 != null && node2 != null) {
            node1.next = node2;
            link(node1.right, node2.left);
        }
    }

    public void dis(List<Node> list, Node node, int i) {
        if (node != null) {
            if (i == list.size()) {
                list.add(node);
            } else {
                Node lastNode = list.get(i);
                lastNode.next = node;
                list.set(i, node);
            }
            dis(list, node.left, i + 1);
            dis(list, node.right, i + 1);
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);

        node.left.left = new Node(4);
        node.left.right = new Node(5);

        node.right.left = new Node(6);
        node.right.right = new Node(7);

        node.left.left.left = new Node(8);
        node.left.left.right = new Node(9);

        node.left.right.left = new Node(10);
        node.left.right.right = new Node(11);

        node.right.left.left = new Node(12);
        node.right.left.right = new Node(13);

        node.right.right.left = new Node(14);
        node.right.right.right = new Node(15);

        new Solution0116M().dis(node);

        System.out.println(node.toLineString());
        System.out.println(node.left.toLineString());
        System.out.println(node.left.left.toLineString());
        System.out.println(node.left.left.left.toLineString());

    }
}