#include "bits/stdc++.h"

using namespace std;

class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        vector<int> res(2);
        for (int x : nums) {
            int k = abs(x);
            if (nums[k-1] < 0) res[0] = k;
            nums[k-1] *= -1;
        }
        for (int k = 0; k < nums.size(); k++) {
            if (nums[k] > 0 && k+1 != res[0]) res[1]=k+1;
        }
        return res;
    }
};