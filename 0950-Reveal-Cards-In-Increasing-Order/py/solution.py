class Solution:
    def deckRevealedIncreasing(self, deck):
        deck.sort()
        ans = []
        while deck:
            if ans:
                ans.insert(0, ans.pop())
            ans.insert(0, deck.pop())
        return ans


if __name__ == '__main__':
    print(111)
