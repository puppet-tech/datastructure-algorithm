# coding:utf-8
# question:
# 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
import numpy as np
class Solution:
    def longestPalindrome(self, s):
        '''最长回文子串----中心扩散法--medium'''
        # 对称问题可考虑中心扩散法
        # 1.回文串分为奇偶回文串，所以需要考虑奇偶两种情况
        # 2.遍历每一个元素，并以每个元素为中心，向两边扩散，
        # 3.考虑奇，由k-1, k+1开始，当满足i、j边界和s[i] == s[j]时，i -= 1、j += 1
        # 4.考虑偶，由k, k+1开始，当满足i、j边界和s[i] == s[j]时，i -= 1、j += 1
        # 5.当不满足上述条件，则说明s[i+1:j]是一个回文串
        # 6.记录回文串及其长度，每次判断最长回文串，并保留，最后再返回
        # 7.边界问题：当s为''时，返回''
        if s == '':
            return s  # 如果只有return，则返回None，但是应该返回''才对
        s_len = len(s)
        ans = ''
        ans_len = 0
        for k in range(s_len):
            # 奇数回文串
            i, j = k - 1, k + 1
            while i >= 0 and j < s_len and s[i] == s[j]:
                i -= 1
                j += 1
            if (j - i - 1) > ans_len:
                ans_len = j - i - 1
                ans = s[i+1:j]
            # 偶数回文串
            i, j = k, k + 1
            while i >= 0 and j < s_len and s[i] == s[j]:
                i -= 1
                j += 1
            if (j - i - 1) > ans_len:
                ans_len = j - i - 1
                ans = s[i+1:j]
        return ans

        # 由上述分析：时间复杂度为O(n^2)，空间复杂度为O(1)

    def longestPalindrome01(self, s):
        '''最长回文子串----动态规划'''
        # 一般子结构最优，可用动态规划
        # 1.状态：dp[i, j]是否为回文串
        # 2.状态转移：dp[i, j] 取决于 dp[i+1, j-1]与s[i] == s[j]
        # 注意转移函数：dp[i, j] = (dp[i+1, j-1] or j - i <= 2) and s[i] == s[j]
        s_len = len(s)
        if s_len <= 1:
            return s
        ans_len = 1  # 到此，s至少有两个字符，则长度必大于等于1
        ans = s[0]
        dp = np.zeros((s_len, s_len), dtype=bool)
        for j in range(1, s_len):  # 注意循环的先后循序和范围
            for i in range(j):
                dp[i, j] = (dp[i+1, j-1] or j - i <= 2) and s[i] == s[j]  # 好好理解or
                if dp[i, j]:
                    if j - i + 1 > ans_len:
                        ans_len = j - i + 1
                        ans = s[i:j+1]  # 切片，用冒号
        return ans

        # 经上述分析：时间复杂度O(n^2)，空间复杂度O(n^2)


if __name__ == '__main__':
    solu = Solution()
    s = 'aaaa'
    print(solu.longestPalindrome01(s))
