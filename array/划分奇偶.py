# coding:utf-8
# 输入一个无序整数数组，调整数组中数字的顺序，
# 所有偶数位于数组的前半部分，使得所有奇数位于数组的后半部分。
# 要求时间复杂度为O(n)。
# Difficulty: easy
def dividing_parity(alist):
    '''quick sorting thought'''
    # 先把数组中的第一个数存放起来，并定义两个游标
    alist_len = len(alist)
    temp = alist[0]
    low = 0
    high = alist_len - 1
    # 先从右到左遍历查看是否是奇数，如果是，则移动游标，否，赋值给low
    # 赋值后，high停，low移动，判断是否为偶，否，赋值给high，low停，以此循环
    while low < high:
        while low < high and (alist[high] % 2) == 1:
            high -= 1
        alist[low] = alist[high]
        while low < high and (alist[low] % 2) == 0:
            low += 1
        alist[high] = alist[low]
    alist[low] = temp

if __name__ == '__main__':
    alist = input().split(' ')
    map(int, alist)
    dividing_parity(alist)
    map(str, alist)
    print((' ').join(alist))


