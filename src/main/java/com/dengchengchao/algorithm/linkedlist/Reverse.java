package com.dengchengchao.algorithm.linkedlist;

import com.dengchengchao.algorithm.util.ResultPlay;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author dengchengchao
 * @date 2018/10/18 14:41
 * <p>
 * 题目：反转一个链表：a->b->c 转为 c->b->a
 */
public class Reverse {

    private static class Node {
        int item;
        Node next;

        Node(int item, Node next) {
            this.item = item;
            this.next = next;
        }

        public Node(int item) {
            this.item = item;
        }
    }

    static Node reverseByRecursion(Node node) {
        if (node.next == null) return node;
        Node newNode= reverse(node.next);
        node.next.next = node;
        node.next = null;
        return newNode;
    }

    static Node reverse(Node node) {
        Node preNode = null;
        Node nextNode = null;
        while (node != null) {
            nextNode = node.next;
            node.next = preNode;
            preNode = node;
            node = nextNode;
        }


        return preNode;
    }

    //通过栈记录先进后出规则，先放入节点，再取出即可
    static Node reverseByStack(Node node) {
        LinkedList<Node> stack = new LinkedList<>();
        for (Node h = node; h != null; h = h.next) {
            stack.push(h);
        }
        Node n=null;
        while (!stack.isEmpty()) {
            n = stack.pop();
            n.next = stack.peek();
        }
        return n;
    }


    static void printStack(Node node) {
        for (; node != null; node = node.next) {
            System.out.print(node.item + " -> ");
        }
        System.out.println("null");
    }


    static Node getTestNode(int count) {
        List<Node> nodes = new ArrayList<>();
        Node pre = new Node(count);
        Node head = pre;
        while (--count != 0) {

            Node node = new Node(count);
            pre.next = node;
            pre = node;
            nodes.add(node);
        }

        return head;
    }

    public static void main(String[] args) {
        Node node1 = getTestNode(100000);

        Node last;
        for (last=node1;last.next!=null;){
            last=last.next;
        }
        final Node lastFinal=last;

        printStack(node1);

        ResultPlay.run(() -> {
            reverseByStack(node1);
            //printStack(lastFinal);
        });
        reverseByStack(lastFinal);


        ResultPlay.run(() -> {
            reverse(node1);
           // printStack(lastFinal);
        });
        reverse(lastFinal);


        ResultPlay.run(() -> {
            reverseByRecursion(node1);
           // printStack(lastFinal);
        });
        reverseByRecursion(lastFinal);

    }

    //----------------
    //测试完成：reverseByStack
    //运行时间：14763 ms
    //
    //----------------
    //----------------
    //测试完成：reverse
    //运行时间：1652 ms
    //
    //----------------
    //----------------
    //测试完成：reverseByRecursion
    //运行时间：297 ms

    //可以看到，虽然不提倡使用递归，但是递归的效率貌似是最高的，而使用数据结构：栈，运行效率是最慢的，应该是每次都需要new 一个Node来放置东西带来的影响
}
