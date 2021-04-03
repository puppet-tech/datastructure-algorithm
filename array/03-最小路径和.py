# coding: utf-8
# question:
# 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，
# 使得路径上的数字总和为最小。
# 说明：每次只能向下或者向右移动一步。
class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        '''最小路径和----动态规划--medium'''
        # 1.状态：现在在第m行、第n列处
        # 2.状态转移：从第m-1行、第n列 or 从第m行、第n-1列
        # dp[m][n] = min(dp[m-1][n], dp[m][n-1]) + grid[m][n]
        # 3.base case：
        # ①grid为[[]]；②dp[0][0]=grid[0][0]
        # 4.考虑边界：（特殊情况）
        # ①第一行；②第一列
        if grid == [[]]:
            return 0
        rows = len(grid)
        cols = len(grid[0])
        dp = [[0 for i in range(cols)] for j in range(rows)]  # 用列表模拟二维数组
        for i in range(rows):
            for j in range(cols):
                if i == 0 and j == 0:  # 第一个格
                    dp[i][j] = grid[0][0]
                elif i == 0 and j != 0:  # 第一行
                    dp[i][j] = dp[i][j-1] + grid[i][j]
                elif i != 0 and j == 0:  # 第一列
                    dp[i][j] = dp[i-1][j] + grid[i][j]
                else:  # 其他情况
                    dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
        return dp[rows-1][cols-1]

        # 由上分析：时间复杂度O(n^2)，空间复杂度O(n^2)
