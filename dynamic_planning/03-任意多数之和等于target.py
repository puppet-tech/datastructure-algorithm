# coding:utf-8
# 给定一个数组和一个target值，
# 如果可以从数组中取出任意个数的数并相加使其等于target，
# 则返回True，否则，返回False
import numpy as np
def rec_subset(arr, i, target):
    '''递归'''
    if target == 0:
        return True
    if i == 0:
        return arr[0] == target
    if arr[i] > target:
        return rec_subset(arr, i-1, target)
    return rec_subset(arr, i-1, target) or rec_subset(arr, i-1, target-arr[i])


def dp_subset(arr, target):
    '''动态规划'''
    # 定义一个二维的数组保存各个状态
    subset = np.zeros((len(arr), target+1), dtype=bool)
    # 出口
    subset[:, 0] = True
    subset[0, :] = False
    subset[0, arr[0]] = True
    for i in range(1, len(arr)):
        for j in range(1, target+1):
            if arr[i] > j:
                subset[i, j] = subset[i-1, j]
            else:
                subset[i, j] = subset[i-1, j] or subset[i-1, j-arr[i]]
    l, h = subset.shape
    return subset[l-1, h-1]


if __name__ == '__main__':
    arr = [3, 34, 4, 12, 5, 2]
    arr_len = len(arr)
    print(rec_subset(arr, arr_len - 1, 13))
    print(rec_subset(arr, arr_len - 1, 9))
    print(dp_subset(arr, 9))
    print(dp_subset(arr, 13))
