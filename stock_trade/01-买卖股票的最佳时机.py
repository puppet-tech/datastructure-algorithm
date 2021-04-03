# coding: utf-8
# question:
# 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
# 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
# 注意你不能在买入股票前卖出股票。
import numpy as np
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        '''买卖股票的最佳时机----动态规划(一维DP)--easy'''
        # 1.状态：第几天，是否持有
        # 2.状态转移：
        # 未持有=前一天未持有且不买 or 前一天持有但卖出
        # 持有=前一天持有但不卖 or 前一天未持有但买入
        # 3.base case：
        # 第一天未持有且不买，利润为 0
        # 第一天未持有但买入，利润为 -prices[0]
        # if prices == []:
        #     return 0
        # prices_len = len(prices)
        # dp = np.zeros(prices_len, dtype=int)  # 指明类型，不然会出现浮点数
        # dp[0] = 0
        # dp_1 = -prices[0]
        # for i in range(1, prices_len):
        #     dp[i] = max(dp[i-1], dp_1 + prices[i])
        #     dp_1 = max(dp_1, -prices[i])
        # return dp[prices_len-1]

    # 经上分析，时间复杂度：O(n)，空间复杂度：O(n)

    # 优化：容易看出，dp[i]只跟前一个状态有关，所以只需要把前一个状态保存下来就可以了，
    # 这样子可以把空间复杂度降低到 O(1)
        if prices == []:
            return 0
        prices_len = len(prices)
        dp_0 = 0
        dp_1 = -prices[0]
        for i in range(1, prices_len):
            dp_0 = max(dp_0, dp_1 + prices[i])
            dp_1 = max(dp_1, -prices[i])
        return dp_0




