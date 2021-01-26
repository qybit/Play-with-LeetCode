class Solution {
public:
    int numEquivDominoPairs(vector<vector<int>>& dominoes) {
        for (auto &x : dominoes) {
            if (x[0] > x[1]) swap(x[0], x[1]);
        }
        unordered_map<string, int> hash;
        int res = 0;
        for (auto &x : dominoes) {
            string s = to_string(x[0]) + to_string(x[1]);
            hash[s]++;
        }
        for (auto &[k, v] : hash) {
            res += v * (v-1) / 2;
        }
        return res;
    }
};