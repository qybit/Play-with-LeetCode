#include "bits/stdc++.h"

using namespace std;

class Solution {
 public:
  int minimumMountainRemovals(vector<int>& nums) {
    int n = nums.size();
    vector<int> f(n, 0), g(n, 0);
    for (int i = 0; i < n; i++) {
      f[i] = g[i] = 1;
    }

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          f[i] = max(f[i], f[j] + 1);
        }
      }
    }
    for (int i = n - 2; i >= 0; i--) {
      for (int j = i + 1; j < n; j++) {
        if (nums[j] < nums[i]) {
          g[i] = max(g[i], g[j] + 1);
        }
      }
    }

    int res = 0;
    for (int i = 0; i < n; i++) {
      if (f[i] > 1 && g[i] > 1) {
        res = max(res, g[i] + f[i] - 1);
      }
    }
    return n - res;
  }
};

int main() {
  Solution s;
  vector<int> v;
  v.push_back(1);
  v.push_back(3);
  v.push_back(1);
  cout << s.minimumMountainRemovals(v);
}