/**
 * @author qybit
 * @create 2020-12-08 10:54
 * @Since 1.0.0
 */
public class Solution {

    static class DSU {
        int[] f;

        public DSU(int n) {
            f = new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = i;
            }
        }

        public int find(int x) {
            return f[x] == x ? x : find(f[x]);
        }

        public void join(int a, int b) {
            int fa = find(a), fb = find(b);
            if (fa != fb) f[fa] = fb;
        }

        public boolean isConnected(int a, int b) {
            return find(a) == find(b);
        }
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;
        DSU dsu = new DSU(n);
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    if (!dsu.isConnected(i, j)) {
                        dsu.join(i, j);
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
