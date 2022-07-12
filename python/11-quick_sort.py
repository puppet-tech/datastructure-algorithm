import random


# def quick_sort(alist, first, last):
#     '''快速排序-不稳定排序-最坏为O(n^2)-最优为O(nlogn)'''
#     if first >= last:
#         return
#     mid_value = alist[first]
#     low = first
#     high = last
#
#     while low < high:
#         while low < high:
#             if alist[high] <= mid_value:
#                 alist[low] = alist[high]
#                 break
#             else:
#                 high -= 1
#
#         while low < high:
#             if alist[low] > mid_value:
#                 alist[high] = alist[low]
#                 break
#             else:
#                 low += 1
#
#     alist[low] = mid_value
#
#     quick_sort(alist, first, low - 1)
#     quick_sort(alist, low + 1, last)
def quick_sort(arr, start, end):
    """快速排序"""
    if start >= end:
        return
    pivot = arr[start]
    p = start
    r = end
    while p < r:
        while p < r:
            if arr[r] < pivot:
                arr[p] = arr[r]
                break
            r -= 1
        while p < r:
            if arr[p] > pivot:
                arr[r] = arr[p]
                break
            p += 1
    arr[p] = pivot
    quick_sort(arr, start, p - 1)
    quick_sort(arr, p + 1, end)


def swap(arr, i, j) -> None:
    arr[i], arr[j] = arr[j], arr[i]


def generate_random_array(max_size: int, max_value: int) -> list:
    arr = [None] * random.randrange(max_size + 1)
    for index in range(len(arr)):
        arr[index] = random.randrange(max_value + 1)
    return arr


def comparator(arr: list) -> None:
    arr.sort()


def copy_array(arr: list) -> list:
    if arr is None:
        return None
    copied_array = [None] * len(arr)
    for index, item in enumerate(arr):
        copied_array[index] = item
    return copied_array


def print_array(arr: list) -> None:
    if arr is None:
        return
    for item in arr:
        print(str(item), end=' ')
    print()


def is_equal(arr1: list, arr2: list) -> bool:
    if (arr1 is None and arr2 is not None) or (arr1 is not None and arr2 is None):
        return False
    if arr1 is None and arr2 is None:
        return True
    if len(arr1) != len(arr2):
        return False
    for index in range(len(arr1)):
        if arr1[index] != arr2[index]:
            return False
    return True


if __name__ == '__main__':
    test_times = 100
    max_size = 10
    max_value = 100
    succeed = True
    for i in range(test_times):
        arr1 = generate_random_array(max_size, max_value)
        arr2 = copy_array(arr1)
        # 用自己编写的排序算法进行排序
        quick_sort(arr1, 0, len(arr1) - 1)
        # 用系统自带的排序算法进行测试，即对数器
        comparator(arr2)
        if not is_equal(arr1, arr2):
            print(arr1)
            print(arr2)
            succeed = False
            break
    print('Nice' if succeed else 'Fucking fucked!')

    # 常规测试
    # arr = generate_random_array(max_size, max_value)
    # print_array(arr)
    # quick_sort(arr, 0, len(arr) - 1)
    # print_array(arr)
