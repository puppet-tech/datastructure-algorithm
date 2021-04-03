# coding:utf-8
# question:
# 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
# 有效字符串需满足：
# 1. 左括号必须用相同类型的右括号闭合。
# 2. 左括号必须以正确的顺序闭合。
# 注意空字符串可被认为是有效字符串。
# Difficulty: medium
def is_valid(s):
    '''stack and hash map'''
    # 使用栈
    # 1.基于一个有效的字符串，其子字符串也有效
    # 2.定义一个栈，遍历字符串的每一个符号，将开符号入栈，遇到闭符号，
    # 3.则判断栈顶元素是否与闭符号同一类型（可以用字典来映射），如果相同，则将栈顶元素出栈，
    # 4.如果不同，则该字符串无效；此外，当遍历完最后一个字符时，栈不为空，
    # 5.该字符串也无效
    if s == '':
        return True
    mapping = {')': '(' , ']': '[', '}': '{'}
    if s[0] in mapping:
        return False
    stack = []
    for char in s:
        if char in mapping.values():
            stack.append(char)
        elif char in mapping:
            if stack:  # 避免栈为空时，stack[-1]报错
                if stack[-1] == mapping[char]:
                    stack.pop()
                else:
                    return False
            else:
                return False
    return not stack

