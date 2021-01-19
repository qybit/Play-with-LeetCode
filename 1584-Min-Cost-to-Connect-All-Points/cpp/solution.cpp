#include "bits/stdc++.h"
typedef pair<int,int> PII;
class Solution {
public:
    int minCostConnectPoints(vector<vector<int>>& points) {
        priority_queue<PII, vector<PII>, greater<PII>> pq;
        int n = points.size();
        vector<bool> vis(n, false);
        pq.push({0, 0});
        int res = 0;
        while (!pq.empty() && n > 0) {
            int sz = pq.size();
            while (sz--) {
                auto [d, p1] = pq.top();pq.pop();
                if (vis[p1]) continue;

                vis[p1] = true;
                res += d;
                n--;

                for (int p2 = 0; p2 < points.size(); p2 ++) {
                    if (vis[p2]) continue;
                    int dist = abs(points[p1][0] - points[p2][0]) + abs(points[p1][1] - points[p2][1]);
                    pq.push({dist, p2});
                }
            }  
        }
        return res;
    }
};