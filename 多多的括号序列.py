# coding: utf-8
# 有一字符串仅有 "(", ")", "[", "]"组成，已知合法的 “纠缠特性” 字符串定义如下：
# 1.空串是合法的
# 2.如果 子串s 是合法的，那么 "(s)" 和 "[s]" 也是合法的
# 3.如果 子串s 和 子串t 是合法的，那么 "st" 也是合法的
# 求出该字符串中最大满足 “纠缠特性” 的子串长度是多少
# Diffilculty: medium
def len_for_valid(s):
    pass


if __name__ == "__main":
    s1 = "([(][()]]()"
    print(len_for_valid(s1))  # ans = 4
    s2 = "([)]"
    print(len_for_valid(s2))  # ans = 0









