# coding:utf-8

# question:
# 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        '''无重复字符的最长子串----双指针＋哈希表--medium'''
        #
        if s == '':
            return 0
        ans = 1
        start = 0
        hash_ = {s[start]: 0, }
        for end in range(1, len(s)):
            if s[end] not in hash_:
                hash_[s[end]] = end
                ans = max(ans, end-start+1)
            else:
                start = hash_[s[end]]
                hash_[s[end]] = end
                ans = max(ans, end-start+1)
        return ans




if __name__ == '__main__':
    solu = Solution()
    s = 'abcabcbb'
    print(solu.lengthOfLongestSubstring(s))




