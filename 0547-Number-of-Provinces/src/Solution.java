class Solution {

    class DSU {
        int[] f;
        public DSU(int n) {
            f = new int[n];
            for (int i =  0; i < n; i++) f[i] = i;
        }

        public int find(int x) {
            if (f[x] != x) {
                f[x] = find(f[x]);
            }
            return f[x];
        }

        public void union(int x, int y) {
            int fx = find(x), fy = find(y);
            if (fx != fy) {
                f[fx] = fy;
            }
        }
    }

    public int findCircleNum(int[][] g) {
        int n  = g.length;
        DSU dsu = new DSU(n);
        for (int i = 0 ; i < n; i++) {
            for (int j = i + 1; j < n; j ++ ) {
                if (g[i][j] == 1) dsu.union(i, j);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (dsu.find(i) == i) res++;
        }
        return res;
    }
}