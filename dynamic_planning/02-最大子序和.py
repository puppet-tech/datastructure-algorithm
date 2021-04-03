# coding:utf-8

# import numpy as np

# 问题
# 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        '''求最大的子序和----'''
        # 1.定义两个变量sum_和ans，sum_是当前最大子序列的和
        # 2.遍历每个元素，如果sum_>=0，说明对结果有增益，sum_保留，并加上当前元素值
        # 3.如果sum_<0，说明无增益，舍弃，直接把将当前元素值赋给sum_
        # 4.每次都要比较sum_和ans，取最大值，赋给ans，遍历结束后，返回ans
        nums_len = len(nums)
        if nums_len == 1:
            return nums[0]
        sum_ = 0
        ans = nums[0]
        for i in range(0, nums_len):
            if sum_ >= 0:
                sum_ += nums[i]
            else:
                sum_ = nums[i]
            ans = max(ans, sum_)
        return ans


