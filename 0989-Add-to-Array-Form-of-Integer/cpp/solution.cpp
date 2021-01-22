#include "bits/stdc++.h"
class Solution {
public:
    vector<int> addToArrayForm(vector<int>& A, int k) {
        vector<int> res;
        int n  = A.size();
        for (int i = n-1; i >= 0; i--) {
            int carry = A[i] + k%10;
            k /= 10;
            if (carry >= 10) k++,carry -= 10;
            res.push_back(carry);
        } 
        for ( ; k > 0; k /= 10)  res.push_back(k%10);
        reverse(res.begin(), res.end());
        return res;
    }
};