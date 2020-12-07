#include "bits/stdc++.h"

using namespace std;

class Solution {
 public:
  int minimumIncompatibility(vector<int>& nums, int k) {
    int n = nums.size(), INF = 1e8;
    vector<int> f(1 << n, INF);  // f[i] 的每一个数的每一位代表一个元素
    vector<int> g(1 << n, -1);  // g[i] 是校验合法性
    f[0] = 0;
    for (int i = 1; i < 1 << n; i++) {       // 枚举所有的子集
      if (__builtin_popcount(i) == n / k) {  // 确定每个子集中的元素个数
        vector<int> d;                       // 子集元素数组
        for (int j = 0; j < n; j++) {
          if (i >> j & 1) {  // 选择元素，如果
            d.push_back(nums[j]);
          }
        }
        sort(d.begin(), d.end());
        // 退出信号   子集中的最小值和最大值
        int flag = 1, maxv = d[0], minv = d[0];
        for (int j = 1; j < d.size(); j++) {
          if (d[j] == d[j - 1]) {
            flag = 0;
            break;
          }
          maxv = max(maxv, d[j]);
          minv = min(minv, d[j]);
        }
        if (flag) {
          // 合法的不兼容性
          g[i] = maxv - minv;
        }
      }
    }
    // 枚举子集
    for (int i = 1; i < 1 << n; i++) {
      for (int j = i; j; j = i & (j - 1)) {
        if (g[j] != -1) f[i] = min(f[i], f[i - j] + g[j]);
      }
    }
    int res = f[(1 << n) - 1];
    if (res == INF) res = -1;
    return res;
  }
}