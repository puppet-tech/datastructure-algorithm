# coding: utf-8
# question:
# 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。
# 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
# 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
# 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。
# 当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
# 要求：时间复杂度为O(1)
# Difficulty: medium
from collections import OrderedDict
class LRUCache(object):
    '''哈希表、双向链表'''
    # 1.题目中的缓冲数据为KV映射形式，可以用字典, dictionay is disordered
    # 2.最新访问、新添加和久不访问的需要分开, use queue
    # 3.queue should has the functions:
    # first, remove the elem at the front;
    # second, add the elem at the rear;
    # finally, move elem to the end;
    # according to the above, use double-end linked list to make time at O(1)
    # In python, the class "OrderedDict" satisfys the conditions
    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.ordered_dict = OrderedDict()
        self.capacity = capacity

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if key in self.ordered_dict:
            self.ordered_dict.move_to_end(key)
            return self.ordered_dict[key]
        else:
            return -1

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        # judge if the key is in the ordered_dict
        if key in self.ordered_dict:
            # if true, cover its value, and move it to the end
            self.ordered_dict[key] = value
            self.ordered_dict.move_to_end(key)
        else:
            # if false, judge if the capacity overflow
            if len(self.ordered_dict) == self.capacity:
                # if true, remove the first one elem
                self.ordered_dict.popitem(last=False)  # 取出第一个
            # whether it is true or false, the elem should be added at the rear
            self.ordered_dict[key] = value

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
