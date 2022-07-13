package com.kovizone.leetcode;

/**
 * Node
 *
 * @author KV
 * @since 2022/07/12
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
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

    public String toLineString() {
        return "[" + val + "]" + (next == null ? "" : " -> " + next.toLineString());
    }

    @Override
    public String toString(){
        return val + "";
    }
}
