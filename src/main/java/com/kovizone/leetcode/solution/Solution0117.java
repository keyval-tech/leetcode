package com.kovizone.leetcode.solution;

import com.kovizone.leetcode.core.Node;

/**
 * <a href="https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/">117. 填充每个节点的下一个右侧节点指针 II</a>
 *
 * @author KV
 * @see Solution0116
 * @since 2022/08/16
 */
public class Solution0117 {

    public Node connect(Node root) {
        Node cur = root;
        while (cur != null) {
            Node thisLay = new Node();
            Node p = thisLay;
            while (cur != null) {
                if (cur.left != null) {
                    p.next = cur.left;
                    p = p.next;
                }
                if (cur.right != null) {
                    p.next = cur.right;
                    p = p.next;
                }
                cur = cur.next;
            }
            cur = thisLay.next;
        }
        return root;
    }

    public Node connect2(Node root) {
        link(root);
        return root;
    }

    public void link(Node node) {
        if (node != null) {
            link(node.left, node.right);
            if (node.left != null) {
                link(node.left);
            }
            if (node.right != null) {
                link(node.right);
            }
        }
    }

    public void link(Node node1, Node node2) {
        if (node1 != null && node2 != null) {
            node1.next = node2;
            link(node1.right == null ? node1.left : node1.right,
                    node2.left == null ? node2.right : node2.left);
        }
    }

    public static void main(String[] args) {
        Node node = Node.parse(1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8);
        System.out.println(node);
        System.out.println(new Solution0117().connect(node).toString());

    }
}
