# coding:utf-8
# question:
# 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
# 使得 a + b + c = 0，找出所有满足条件且不重复的三元组。
# 注意：答案中不可以包含重复的三元组。
class Solution:
    def threeSum(self, nums):
        '''三数之和----双指针--medium'''
        # 1.如果用暴力求解，时间复杂度为O(n^3)
        # 2.使用双指针：动态消除无效解
        # 3.先对数组进行排序；O(nlogn)；此时数组有序，左小右大
        # 4.定义三指针k、i、j，k固定在最左不变，i、j分别于k+1、nums_len-1处
        # 5.如果nums[k]>0,则跳出循环，最终结果为空，因为再无可能有三数之和为零的组合
        # 6.如果k>0 and nums[k] == nums[k-1],则跳过nums[k]，以避免重复组合
        # 7.当i<j时，循环，每次判断nums[k]+nums[i]+nums[j]的和s与0的关系
        # 8.如果大于0，则j-=1并且注意同k一样，避免重复组合
        # 9.如果小于0，则i+=1，同时注意避免重复组合
        # 10.等于0，则保存i、j、k对应值到res，同时移动i、j，注意避免重复组合
        # 11.直到i=j，结束一个循环，k+1，再重新进入循环
        nums.sort()
        nums_len = len(nums)
        res = []
        for k in range(0, nums_len-2):  # 注意：这里是-2，而不是-3，因为range的用法！！！
            if nums[k] > 0:
                break
            elif k > 0 and nums[k] == nums[k-1]:
                continue
            else:
                i = k + 1
                j = nums_len - 1
                while i < j:
                    s = nums[k] + nums[i] + nums[j]
                    if s < 0:
                        i += 1
                        while i < j and nums[i] == nums[i-1]:
                            i += 1
                    elif s > 0:
                        j -= 1
                        while i < j and nums[j] == nums[j+1]:
                            j -= 1
                    else:
                        # s == 0，满足条件
                        res.append([nums[k], nums[i], nums[j]])
                        i += 1
                        j -= 1
                        while i < j and nums[i] == nums[i-1]:
                            i += 1
                        while i < j and nums[j] == nums[j+1]:
                            j -= 1
        return res

        # 由上述思路分析，得时间复杂度O(n^2)；空间复杂度：两个指针，常数级O(1)；

if __name__ == '__main__':
    s = Solution()
    print(s.threeSum([0, 0, 0]))