class Solution:
    def concatenatedBinary(self, n):
        res = ''
        mod = 10 ** 9 + 7
        for i in range(1, n+1):
            b = bin(i)[2:]
            res += b
        return int(res, 2) % mod