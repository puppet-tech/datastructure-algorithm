#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time    : 2019/11/26 21:13
# @Author  : Jack
class Node(object):
    """the node of binary tree"""
    def __init__(self, item):
        self.val = item
        self.lchild = None
        self.rchild = None


class BinaryTree(object):
    """binary tree"""
    def __init__(self, node=None):
        self.root = node

    def add(self, item):
        """
        add node to the binary tree
        :param item: the node to be added
        :return: res
        """
        node = Node(item)
        if self.root == None:
            self.root = node
            return
        queue = [self.root]
        while True:
            cur_node = queue.pop(0)
            if cur_node.lchild == None:
                cur_node.lchild = node
                return
            queue.append(cur_node.lchild)
            if cur_node.rchild == None:
                cur_node.rchild = node
                return
            queue.append(cur_node.rchild)

    def BFS(self):
        """
        breadth first search
        :return: res
        """
        if self.root == None:
            return
        queue = [self.root]
        while queue:
            cur_node = queue.pop(0)
            print(cur_node.val, end="")
            if cur_node.lchild != None:
                queue.append(cur_node.lchild)
            if cur_node.rchild != None:
                queue.append(cur_node.rchild)

    def preorder(self, node):
        """
        preorder of depth first search
        :return: res
        """
        if node == None:
            return
        print(node.val, end="")
        self.preorder(node.lchild)
        self.preorder(node.rchild)

    def inorder(self, node):
        """
        in-order of depth first search
        :return: res
        """
        if node == None:
            return
        self.preorder(node.lchild)
        print(node.val, end="")
        self.preorder(node.rchild)

    def post_order(self, node):
        """
        post-order of depth first search
        :return: res
        """
        if node == None:
            return
        self.preorder(node.lchild)
        self.preorder(node.rchild)
        print(node.val, end="")


if __name__ == "__main__":
    tree = BinaryTree()
    for i in range(10):
        tree.add(i)
    tree.BFS()

    print()
    tree.preorder(tree.root)
    print()
    tree.inorder(tree.root)
    print()
    tree.post_order(tree.root)
