package org.example.stack;

/**
 * 基于链表实现的栈，即为链式栈
 * @author puppet
 * @since 2022/2/1 11:54 上午
 */
public class StackBasedOnLinkedList {

    /**定义栈顶元素指针*/
    private Node top = null;

    /**
     * 入栈操作
     * @param data
     */
    public void push(int data) {
        // 先将入栈的元素封装为节点
        Node node = new Node(data, null);
        // 如果栈为空，则 top 指向 null
        if (top == null) {
            top = node;
        } else {
            // 否则，栈不为空
            node.next = top;
            top = node;
        }
    }

    /**
     * 出栈操作
     * @return
     */
    public int pop() {
        if (top == null) {
            return -1;
        } else {
            // 由于 Node 类定义在 StackBasedOnLinkedList 类内，故可以直接访问 data 属性
            int value = top.data;
            top = top.next;
            return value;
        }
    }

    public void printAll() {
        Node node = top;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackBasedOnLinkedList stack = new StackBasedOnLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.printAll();
    }

    /**
     * 节点类
     */
    private static class Node {
        /**节点数据*/
        private int data;
        /**后继节点*/
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return this.data;
        }
    }
}
