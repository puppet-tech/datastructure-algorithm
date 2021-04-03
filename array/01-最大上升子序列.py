# coding: utf-8
# question:
# 给定一个无序的整数数组，找到其中最长上升子序列的长度。
class Solution:
    def lengthOfLIS(self, nums):
        '''最大上升子序列----动态规划--medium'''
        # state：nums有i+1个值
        # update func：dp[i] = max[dpi], dp[j]+1)
        # base case: one, nums is None; two, nums has only one elem
        nums_len = len(nums)
        if nums_len == 0:
            return 0
        dp = [1 for x in range(nums_len)]
        for i in range(1, nums_len):
            for j in range(i):
                if nums[j] < nums[i]:
                    # 还有这样子才不会遗漏同等长度的最长子序列
                    dp[i] = max(dp[i], dp[j] + 1)  # 如果比前面的某一个值大，则该值所处的位置的状态值+1
        return max(dp)

if __name__ == "__main__":
    nums = [10, 9, 2, 5, 3, 7, 101, 18]
    solu = Solution()
    ans = solu.lengthOfLIS(nums)
    print(ans)