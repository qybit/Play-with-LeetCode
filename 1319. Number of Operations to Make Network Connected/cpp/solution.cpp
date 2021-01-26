#include "bits/stdc++.h"
class DSU {
public:
    vector<int> f;
    int n;
     DSU(int _n): n(_n) {
        f.resize(n);
        for (int i = 0; i < n; i ++) f[i] = i;
    }
    int find(int x) {
        if (f[x] != x) {
            f[x] = find(f[x]);
        }
        return f[x];
    }
    void merge(int x, int y) {
        int fx = find(x), fy = find(y);
        if (fx != fy) {
            f[fx] = fy;
        }
    }
};

class Solution {
public:
    int makeConnected(int n, vector<vector<int>>& connections) {
        if (connections.size() < n - 1) return -1;
        DSU dsu(n);
        for (auto &c : connections) {
            dsu.merge(c[0], c[1]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (dsu.f[i] == i) res++;
        }
        return res - 1;
    }
};