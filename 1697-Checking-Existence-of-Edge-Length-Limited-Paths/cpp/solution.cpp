#include "bits/stdc++.h"

using namespace std;

const int N = 100010;

struct Node {
    int a, b, c, d;
    bool operator < (const Node & t) const {
        return c < t.c;
    }
} e[N], q[N];


class Solution {
public:
    vector<int> f;

    int find (int x) {
        if (x != f[x]) f[x] = find(f[x]);
        return f[x];
    }

    bool is_connected(int x, int y) {
        return find(x) == find(y); 
    }

    vector<bool> distanceLimitedPathsExist(int n, vector<vector<int>>& ee, vector<vector<int>>& qq) {
        int m = ee.size(), k = qq.size();
       

        for (int i = 0; i < m; i++) 
            e[i] = {ee[i][0], ee[i][1], ee[i][2]};
        for (int i = 0; i < k; i++) 
            q[i] = {qq[i][0], qq[i][1], qq[i][2], i};
        sort(e, e + m), sort(q, q + k);
        f.resize(n);
        for (int i = 0; i < n; i++) f[i] = i;
        vector<bool> res(k);
        for (int i = 0, j = 0; i < k; i++) {
            while (j < m && e[j].c < q[i].c) {
                int a = e[j].a, b = e[j].b;
                f[find(a)] = find(b);
                j++;
            }
            res[q[i].d] = is_connected(q[i].a, q[i].b);
        }
        return res;
        
    }
};