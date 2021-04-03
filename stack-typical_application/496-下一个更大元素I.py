# 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
# 找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
# nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。
# 如果不存在，对应位置输出-1。
# Difficulty: easy
class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        '''helper stack'''
        # 1.定义一个辅助栈，利用递减栈思想，把 nums2 里右边存在更大值的元素给找出来，
        # 2.并把该值与其第一个右边更大值用哈希映射一一对应起来
        helper, mapping = [], {}  # define auxiliary stack and hash table
        for num in nums2:
            # 递减栈的核心思想：如果遇到大于栈顶元素的值，就建立哈希映射，
            # 并把栈顶元素弹出，直到栈为空，或小于等于栈顶元素，再将当前值入栈，维护递减栈；
            while helper and helper[-1] < num:
                mapping[helper.pop()] = num
            helper.append(num)
        return [mapping.get(num, -1) for num in nums1]
    # analyse: time complexity: O(n); space complexity: O(n);
