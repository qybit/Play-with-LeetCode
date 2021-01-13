class Solution {

    class DSU{
        int n;
        int[] f;
        public DSU(int _n){
            n = _n;
            f = new int[n + 1];
            for (int i = 0 ;i < f.length;i ++) f[i] = i;
        }

        public int find(int x) {
            if (f[x] != x) {
                f[x] = find(f[x]);
            }
            return f[x];
        }
    
        public void merge(int x, int y){
            int fx = find(x), fy = find(y);
            f[fx] = fy;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n);
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            if (!dsu.isConnected(x, y)) {
                dsu.merge(x, y);
            } else return edge;
        }
        return new int[0];
    }
}