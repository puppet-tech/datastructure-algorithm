# coding:utf-8

# 找出单向链表中的一个节点，该节点到尾指针的距离为K。
# 链表的倒数第0个结点为链表的尾指针。要求时间复杂度为O(n)。
# Difficulty: easy
class Node(object):
    '''节点'''
    def __init__(self, elem):
        self.elem = elem
        self.next = None

class SingleList(object):
    '''double pointer'''
    def __init__(self, node=Node(1)):
        self.__head = node
        for i in range(2, 8):
            node = Node(i)
            cursor = self.__head
            while cursor.next != None:
                cursor = cursor.next
            cursor.next = node

    def get_node(self, k):
        cursor = self.__head
        fore = self.__head
        for i in range(k):
            cursor = cursor.next
        while cursor != None:
            cursor = cursor.next
            fore = fore.next
        return fore.elem


if __name__ == '__main__':
    single_list = SingleList()
    k = int(input())
    print(single_list.get_node(k))












