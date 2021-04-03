# coding:utf-8

import numpy as np

# 问题：在给定的数组中，取出任意数量的数相加，值最大；
# 限制条件，取出的数不能相邻
def rec_opt(arr, i):
    '''递归方式'''
    # 递归出口
    if i == 0:
        return arr[0]
    elif i == 1:
        return max(arr[0], arr[1])
    else:
        A = rec_opt(arr, i-2) + arr[i]
        B = rec_opt(arr, i-1)
        return max(A, B)

def dp_opt(arr):
    '''动态规划'''
    arr_len = len(arr)
    opt = np.zeros(arr_len)
    opt[0] = arr[0]
    opt[1] = max(arr[0], arr[1])
    for i in range(2, arr_len):
        A = opt[i-2] + arr[i]
        B = opt[i-1]
        opt[i] = max(A, B)
    return opt[arr_len - 1]

if __name__ == '__main__':
    arr = [1, 2, 4, 1, 7, 8, 3]
    arr_len = len(arr)
    print(rec_opt(arr, arr_len-1))
    print(dp_opt(arr))