def two_sum(nums, target):
    """
    给定一个整数数组 nums 和一个目标值 target，
    请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
    Difficulty: easy
    :param nums: 给定的数组
    :param target: 目标值
    :return:
    """
    # 利用哈希表
    # a_dict = {}                             # 定义一个字典
    # for i, num in enumerate(nums):          # 把给定的数组，用enumerate函数提取出值和下标
    #     a_dict[num] = i
    # for j, num in enumerate(nums):          # 因为不能重复使用同一个值，所以必须再用一个enumerate
    #     if (target-num) in a_dict and j != a_dict[target-num]:  # 对其进行判断
    #         return [j, a_dict[target-num]]                      # 返回目标结果的下标
    """
    analyse: time complexity is O(2n), space complexity is O(n)
    """

    # 哈希表改进版
    mapping = {}
    for i in range(len(nums)):                # 改进核心思路：一边添加一边查找
        num = nums[i]                         # 将当前遍历到的下标的值取出保存
        if (target - num) in mapping:         # 如果存在，则直接返回，由于当前num还没入字典，所以不会重复。
            return mapping[target-num], i     # 返回结果值的下标
        mapping[num] = i                      # 如果当前没有找到，则将当前num加入字典
    """
    analyse: time complexity is O(n), space complexity is O(n). 改进后，代码更短，时间复杂度更好。
    一旦找到，就提前返回。
    """

    # double pointer
    new_nums = nums[:]          # 浅拷贝，为了保留原数组的下标
    new_nums.sort()             # 对新数组进行排序
    left = 0
    right = len(new_nums) - 1   # 定义left和right指针分别指向新数组的开头和结尾
    while left < right:         # 当left和right不重叠时，不断循环
        if new_nums[left] + new_nums[right] == target:   # 当前后两个相加等于目标时
            return nums.index(new_nums[left]), nums.index(new_nums[right])
        elif new_nums[left] + new_nums[right] < target:
            left += 1       # 当前后两个相加小于目标值时，left += 1，右移
            continue
        else:               # 当前后两个相加大于目标值时，right -= 1，左移
            right -= 1
    """
    analyse: time complexity is O(n^2), space complexity is O(n). 时间复杂度太大，还是用哈希表比较好。
    但是其中的双指针思想很有用，排序，相加，比较大小，太大，则右边变小，太小，则左边变大。
    """


if __name__ == "__main__":
    pass
