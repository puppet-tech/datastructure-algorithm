# 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
# push(x) -- 将元素 x 推入栈中。
# pop() -- 删除栈顶的元素。
# top() -- 获取栈顶元素。
# getMin() -- 检索栈中的最小元素。
# Difficulty: easy
class MinStack:
    '''Double stack'''
    # 1.利用一个辅助栈来与存放数据的栈同步
    # 2.每次添加一个元素，也需要往辅助栈中添加当前最小的元素
    # 3.最小的元素：如果当前添加的元素小于辅助栈栈顶的元素，或者辅助栈为空，则添加当前元素进入
    # 4.否则，则将辅助栈的栈顶元素重复添加进入辅助栈中；
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.__data_stack = []
        self.__min_stack = []

    def push(self, x: int) -> None:
        self.__data_stack.append(x)
        if self.__min_stack == [] or x <= self.__min_stack[-1]:
            self.__min_stack.append(x)
        else:
            self.__min_stack.append(self.__min_stack[-1])

    def pop(self) -> None:
        if self.__data_stack:
            self.__min_stack.pop()
            return self.__data_stack.pop()

    def top(self) -> int:
        if self.__data_stack:
            return self.__data_stack[-1]

    def getMin(self) -> int:
        if self.__min_stack:
            return self.__min_stack[-1]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
