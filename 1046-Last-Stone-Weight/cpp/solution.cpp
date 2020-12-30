#include "bits/stdc++.h"
using namespace std;

class Solution {
public:
  int lastStoneWeight(vector<int> &stones) {
    while (stones.size() > 1) {
      int n = stones.size();
      sort(stones.begin(), stones.end());
      int x = stones[n - 2], y = stones[n - 1];
      stones.pop_back(), stones.pop_back();
      if (x != y) {
        stones.push_back(y - x);
      }
    }
    return stones.empty() ? 0 : stones[0];
  }
};

int main() {}