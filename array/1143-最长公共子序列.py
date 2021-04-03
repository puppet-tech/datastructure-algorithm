# coding: utf-8
# question:
# 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
# 一个字符串的 子序列 是指这样一个新的字符串：
# 它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串.
# 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
# 两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
# 若这两个字符串没有公共子序列，则返回 0。
class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        '''最长公共子序列----动态规划--medium'''
        # 1.状态dp[i][j]为
