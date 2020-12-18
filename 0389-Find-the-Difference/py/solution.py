import typing
class Solution:
    def findTheDifference(self, s: str, t: str) -> str:
        res = 0
        for x in s+t:
            res ^= ord(x)
        return chr(res)