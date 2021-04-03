# coding:utf-8
# question:
# 使用队列实现栈的下列操作：
# push(x) -- 元素 x 入栈
# pop() -- 移除栈顶元素
# top() -- 获取栈顶元素
# empty() -- 返回栈是否为空
# 注意:
# 你只能使用队列的基本操作，即push_to_back, peek/pop from front, size和is_empty这些操作是合法的。
# 你所使用的语言也许不支持队列。 
# 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
# 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
# Difficulty: easy
from collections import deque
class MyStack:
    '''双端队列collections库内的deque'''
    def __init__(self):
        self.__queue = deque()

    def push(self, x: int) -> None:
        """
        Push element x onto stack.
        """
        self.__queue.append(x)

    def pop(self) -> int:
        """
        Removes the element on top of the stack and returns that element.
        """
        if not self.__queue:
            return
        return self.__queue.pop()

    def top(self) -> int:
        """
        Get the top element.
        """
        if not self.__queue:
            return
        return self.__queue[-1]

    def empty(self) -> bool:
        """
        Returns whether the stack is empty.
        """
        return not self.__queue

