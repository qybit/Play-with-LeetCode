#include "bits/stdc++.h"

using namespace std;


class Solution {
 public:
  int findLongestChain(vector<vector<int>>& pairs) {
    sort(pairs.begin(), pairs.end(),
         [](vector<int>& a, vector<int>& b) { return a[1] < b[1]; });

    int res = 1, ed = pairs[0][1];
    for (auto p : pairs) {
      if (p[0] > ed) {
        res++;
        ed = p[1];
      }
    }
    return res;
  }
};

int main() {
  Solution s;

  vector<vector<int>> arr;
  arr.push_back({1, 2});
  arr.push_back({2, 3});
  arr.push_back({3, 4});

  cout << s.findLongestChain(arr);
  return 0;
}
