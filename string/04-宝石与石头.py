# coding: utf-8
# question:
# 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 
# S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
# J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
class Solution:
    def numJewelsInStones(self, J: str, S: str) -> int:
        '''宝石与石头----哈希表--easy'''
        # 1.将J字符串每个字符放进集合gem中，直接用set转换即可；（set为哈希表）
        # 2.定义ans记录宝石数量
        # 3.遍历S中的字符，判断是否在gem中，如果在，则加1，遍历后返回ans
        gem = set(J)
        ans = 0
        for stone in S:
            if stone in gem:
                ans += 1
        return ans

    # 分析：时间复杂度：O(n)；空间复杂度：O(1)


