# 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
# Difficulty: easy
class Solution:
    def backspaceCompare(self, S: str, T: str) -> bool:
        '''double stack'''
        data = []
        helper = []
        for char in S:
            if char == '#':
                if data:
                    data.pop()
            else:
                data.append(char)
        for char in T:
            if char == '#':
                if helper:
                    helper.pop()
            else:
                helper.append(char)
        return data == helper
    # analyse: time complexity: O(n); space complexity: O(n)


if __name__ == "__main__":
    S = "y#fo##f"
    T = "y#f#o##f"
    solu = Solution()
    print(solu.backspaceCompare(S, T))