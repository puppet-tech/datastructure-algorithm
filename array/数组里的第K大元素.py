def find_target_elem(alist, start, end, K):
    """
    要求在 O(n) 时间复杂度内找出给定的无序数组中的第 K 大元素。
    比如：4, 2, 5, 12, 3这样一组数组里，第 3 大元素为 4。
    Difficulty: easy
    :param alist: 给定的无序数组
    :param start: 操作范围下标起点
    :param end: 操作范围下标终点
    :param K: K 的值
    :return: 返回找到的第 K 大元素
    """
    # 利用快排的分区思想
    if start >= end:
        return alist[start]
    mid_val = alist[start]
    low = start                                         #
    high = end
    while low < high:
        while low < high and alist[high] > mid_val:
            high -= 1
        alist[low] = alist[high]
        while low < high and alist[low] < mid_val:
            low += 1
        alist[high] = alist[low]
    alist[low] = mid_val                         # 先找到一个数原本应该在的位置
    if low == K - 1:                             # 如果该数的位置在 K-1，说明该数就是第 K 大元素
        return alist[low]
    elif low < K - 1:                            # 否则，说明在两边，用递归分别调用原函数，并返回
        return find_target_elem(alist, low+1, end, K)
    else:                                        # 关键思想，找到了某数位置，前面都比它小，后边都比它大
        return find_target_elem(alist, start, low-1, K)
"""
analyse: time complexity is O(n), space complexity is O(1)
"""


if __name__ == "__main__":
    alist = [4, 2, 5, 12, 3]
    print(find_target_elem(alist, 0, 4, 5))
