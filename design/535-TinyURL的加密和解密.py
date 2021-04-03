# coding: utf-8
# TinyURL是一种 URL 简化服务，
# 比如：当你输入一个URL https://leetcode.com/problems/design-tinyurl 时，
# 它将返回一个简化的URL http://tinyurl.com/4e9iAk.
# 要求：设计一个 TinyURL 的加密 encode 和解密 decode 的方法。
# 你的加密和解密算法如何设计和运作是没有限制的，
# 你只需要保证一个URL可以被加密成一个TinyURL，并且这个TinyURL可以用解密方法恢复成原本的URL。
# Difficulty: medium
from random import sample
class Codec:
    '''hash map'''
    # 1.定义字典，作为映射；编码时，将编码后的URL和原URL作为键值对添加到字典中
    # 2.解码时，根据传入的URL去字典中查找，返回对应的值
    # 3.编码加密使用固定长的随机字符，如果产生了相同的随机字符，则令其重新生成，直到不同为止；
    def __init__(self):
        self.mappings = {}

    def encode(self, longUrl):
        """Encodes a URL to a shortened URL.

        :type longUrl: str
        :rtype: str
        """
        sample_chars = 'qwertyuiopasdfghjklzxcvbnm123456789'  # 定义一个随机样本集
        while True:
            token = ''.join(sample(sample_chars, 6))  # 从随机样本集中随机取出6个字符，拼接成字符串
            if token not in self.mappings:  # 生成的token不能跟mappings里的重复
                break
        self.mappings[token] = longUrl
        return 'http://tinyurl.com/' + token

    def decode(self, shortUrl):
        """Decodes a shortened URL to its original URL.

        :type shortUrl: str
        :rtype: str
        """
        token = shortUrl.split('/').pop()
        return self.mappings[token]

    # 分析：加密使用了随机等长标识加密，标识符数量可达36^36种，规律不可发现，难破解；
    # 在URL的数量较少时，出现重复的可能性不大；
    # 映射采用哈希表，时间复杂度为O(1)，解密快

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(url))
