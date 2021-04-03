# coding:utf-8

import numpy as np

# 问题：
# 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
# 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
class Solution:
    def climbStairs(self, n: int) -> int:
        # 1.状态：方法的数量
        # 2.状态转移：methods[i] = methods[i-1] + methods[i-2]
        # 3.出口：当 i==1 时，methods[1] = 1，当 i == 2 时，methods[2] = 2
        if n == 1:
            return 1
        elif n == 2:
            return 2
        methods = np.zeros(n, dtype=int)
        methods[0] = 1
        methods[1] = 2
        for i in range(3, n + 1):
            methods[i - 1] = methods[i - 2] + methods[i - 3]
        return methods[n - 1]

