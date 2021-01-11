#include "bits/stdc++.h"
using namespace std;
class DSU{
public:
    vector<int> f, rank;
    int n;

    DSU (int _n) {
        n = _n;
        f.resize(n);
        rank.resize(n, 1);
        for (int i = 0; i < n; i ++) {
            f[i] = i;
        }
    }

    int find(int x) {
        if (x != f[x]) {
            f[x] = find(f[x]);
        }
        return f[x];
    }

    void join(int x, int y) {
        int fx = find(x), fy = find(y);
        if (fx != fy) {
            if (rank[fx] < rank[fy]) {
                swap(fx, fy);
            }
            rank[fx] += rank[fy];
            f[fy] = fx;
        }
    }

};

class Solution {
public:
    string smallestStringWithSwaps(string s, vector<vector<int>>& pairs) {

        DSU dsu(s.size());
        for (auto &it : pairs) {
            dsu.join(it[0], it[1]);
        }
        unordered_map<int, vector<int>> mp;
        for (int i = 0; i < s.size(); i ++) {
            mp[dsu.find(i)].push_back(s[i]);
        }
        for (auto &[k, v] : mp) {
            sort(v.begin(), v.end(), greater<int>());
        }
        for (int i = 0; i < s.size(); i ++) {
            int x = dsu.find(i);
            s[i] = mp[x].back();
            mp[x].pop_back();
        }
        return s;
    }
};