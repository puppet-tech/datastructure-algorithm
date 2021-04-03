def continuous_LCS(str1, str2):
    """
    给定两个字符串str1和str2，输出两个字符串的最长连续公共子串，如果最长公共子串为空，输出-1。
    如果存在多个等长公共子串，则按字母数字排序输出，即：
    输入：
    abcdefghijklmnop
    abcsafjklmnopqrstuvw
    输出： jklmnop
    Difficulty: medium
    :param str1: 字符串1
    :param str2: 字符串2
    :return: 最长的公共子串
    """
    # dynamic plan
    len_str1 = len(str1)
    len_str2 = len(str2)

    # dp[i][j], indicating that the str1 ends with str1[i] and str2 with str2[j]
    # define a two-dimensional array using list
    dp = [[0 for i in range(len_str1)] for j in range(len_str2)]

    # base case
    for j in range(len_str1):
        if str1[j] == str2[0]:              # 当 str1 只有一个字符时
            dp[0][j] = 1
    for i in range(len_str2):
        if str2[i] == str1[0]:              # 当 str2 只有一个字符时
            dp[i][0] = 1
    max_len = 0
    max_end = 0
    for i in range(1, len_str1):
        for j in range(1, len_str2):
            if str1[i] == str2[j]:
                dp[i][j] = dp[i-1][j-1] + 1  # dp[i][j] is only from dp[i-1][j-1] due to continuity
            if dp[i][j] > max_len:
                max_len = dp[i][j]
                max_end = i
    if max_len == 0:
        return -1
    else:
        return str1[max_end-max_len+1:max_end+1]


if __name__ == "__main__":
    str1 = "1AB2345CD"
    str2 = "12345EF"
    print(continuous_LCS(str1, str2))



