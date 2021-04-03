# 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
# Difficulty: medium
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        '''dynamic planning'''
        # 状态，n=i时，所有有效括号的组合
        if n == 0:
            return []
        dp = []  # 存放所有状态
        dp.append([None])  # n=0 时
        dp.append(["()"])  # n=1时
        for i in range(2, n+1):  # 遍历计算n=2, n=3,...n=i时的状态
            status_i = []  # 存放n=i时的状态
            for j in range(i):  # p + q = n - 1,遍历p的可能状态，q = n - p - 1
                p_status = dp[j]  # 取出p的状态
                q_status = dp[i-j-1]  # q的状态随p改变

                # 从p_status和q_status取出情况，并进行组合
                for s_01 in p_status:
                    for s_02 in q_status:
                        if s_01 == None:  # 取出的情况可能为None，需要用""代替
                            s_01 = ""
                        if s_02 == None:
                            s_02 = ""
                        s = "(" + s_01 + ")" + s_02
                        status_i.append(s)
            dp.append(status_i)
        return dp[n]


