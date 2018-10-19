package com.dengchengchao.algorithm.binarytree;

import com.dengchengchao.algorithm.stack.Stack;
import com.dengchengchao.algorithm.util.ResultPlay;
import sun.reflect.generics.tree.Tree;

import javax.xml.soap.Node;
import java.util.LinkedList;

/**
 * @author dengchengchao
 * @date 2018/10/18 15:34
 */
public class BinaryTree {

    static class TreeNode {

        int data;

        TreeNode left;

        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    //递归先序遍历
    static void preOrderTraverseByRecursion(TreeNode head) {
        if (head == null) return;
        System.out.println(head.data + " ");
        preOrderTraverseByRecursion(head.left);
        preOrderTraverseByRecursion(head.right);

    }


    //非递归先序遍历
    static void preOrderTraverse(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();
        for (TreeNode nowNode = head; nowNode != null || !stack.isEmpty(); ) {
            if (nowNode != null) {
                stack.push(nowNode);
                System.out.println(nowNode.data);
                nowNode = nowNode.left;
            } else {
                nowNode = stack.pop().right;
            }
        }
    }

    //递归中序遍历
    static void inOrderTraverseByRecursion(TreeNode head) {
        if (head == null) return;
        inOrderTraverseByRecursion(head.left);
        System.out.println(head.data + " ");
        inOrderTraverseByRecursion(head.right);

    }

    //非递归中序遍历
    static void inOrderTraverse(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();
        for (TreeNode nowNode = head; nowNode != null || !stack.isEmpty(); ) {
            if (nowNode != null) {
                stack.push(nowNode);
                nowNode = nowNode.left;
            } else {
                System.out.println(stack.top().data);
                nowNode = stack.pop().right;
            }
        }
    }

    //递归后序遍历
    static void postOrderTraverseByRecursion(TreeNode head) {
        if (head == null) return;
        postOrderTraverseByRecursion(head.left);
        postOrderTraverseByRecursion(head.right);
        System.out.println(head.data + " ");
    }


    //非递归后序遍历
    //这里的问题主要是父节点会被访问三次，第一个是通过它将左子节点压栈，第二次获取这个值查看它是否有父节点，第三次是打印该节点
    //第二次和第三次都是通过栈访问，为了区分是否已经访问过一次，可以使用HashSet记录。
    //这里比较巧妙的就是如果这个节点应该出栈，那么上一个出栈的节点一定的它的右节点，因此每次都记录一下出栈的节点是不是该节点的右节点即可
    static void postOrderTraverse(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();

        for (TreeNode nowNode = head, last = null; nowNode != null || !stack.isEmpty(); ) {
            if (nowNode != null) {
                stack.push(nowNode);
                nowNode = nowNode.left;
            } else {
                TreeNode peek = stack.top();
                if (peek.right != null && last != peek.right) {
                    nowNode = peek.right;
                } else {
                    peek = stack.pop();
                    System.out.println(peek.data);
                    last = peek;
                }

            }
        }
    }

    static void levelTraversal(TreeNode head) {
        LinkedList<TreeNode> queque = new LinkedList<>();
        queque.offer(head);
        while (queque.size() != 0) {
            TreeNode node = queque.poll();
            System.out.println(node.data);
            if (node.left != null) {
                queque.add(node.left);
            }
            if (node.right != null) {
                queque.add(node.right);
            }

        }
    }

    public static void main(String[] args) {
        TreeNode nodeTop = new TreeNode(10);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode14 = new TreeNode(14);
        TreeNode treeNode12 = new TreeNode(12);
        TreeNode treeNode16 = new TreeNode(16);
        TreeNode treeNode9 = new TreeNode(9);
        nodeTop.left = treeNode6;
        nodeTop.right = treeNode14;
        treeNode6.left = treeNode4;
        treeNode6.right = treeNode8;
        treeNode14.left = treeNode12;
        treeNode14.right = treeNode16;
        treeNode8.left = treeNode9;


        System.out.println("****************   递归实现  **************");
        ResultPlay.run(() -> preOrderTraverseByRecursion(nodeTop));

        ResultPlay.run(() -> inOrderTraverseByRecursion(nodeTop));

        ResultPlay.run(() -> postOrderTraverseByRecursion(nodeTop));

        System.out.println("****************   非递归实现  **************");

        ResultPlay.run(() -> preOrderTraverse(nodeTop));

        ResultPlay.run(() -> inOrderTraverse(nodeTop));

        ResultPlay.run(() -> postOrderTraverse(nodeTop));

        System.out.println("****************   层次遍历  **************");
        ResultPlay.run(() -> levelTraversal(nodeTop));

    }
}
