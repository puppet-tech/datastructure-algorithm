# coding: utf-8
# question:
# 给定两个字符串，找出其最长的公共子串，如果存在多个等长的公共子串，
# 则将其按照字符排序，依次分行打印
import sys
def find_common_string(str01, str02):
    '''查找字符最长公共子串----'''
    len_01, len_02 = len(str01), len(str02)
    if len_01 > len_02:
        str01, str02 = str02, str01
    temp = []
    ans = []
    for i in range(len_01):
        for j in range(len_02):
            k, d = i, j
            while str01[k] == str02[d]:
                k += 1
                d += 1
            temp.append(str01[i, k])
    max_len = max(map(len, temp))
    for case in temp:
        if len(case) == max_len:
            ans.append(case)
    return list(set(ans))

if __name__ == "__main__":
    for line in sys.stdin:
        substr = line.split()
    str01 = substr[0]
    str02 = substr[1]
    ans = find_common_string(str01, str02)  # 返回一个列表
    for case in ans:
        print(case)
