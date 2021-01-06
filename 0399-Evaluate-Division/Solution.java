class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int idx = 0;
        Map<String, Integer> map = new HashMap<>();
        for (List<String> list : equations) {
            String x = list.get(0);
            String y = list.get(1);
            if (!map.containsKey(x)) map.put(x, idx++);
            if (!map.containsKey(y)) map.put(y, idx++);
        }

        int[] f = new int[idx];
        for (int i = 0; i < idx; i++) f[i] = i;
        double[] w = new double[idx];
        Arrays.fill(w, 1.0);

        int n  = equations.size();
        for (int i = 0; i < n; i++) {
            List<String> list = equations.get(i);
            String x = list.get(0);
            String y = list.get(1);
            merge(f, w, map.get(x), map.get(y), values[i]);
        }

        int m = queries.size();
        double[] res = new double[m];

        for (int i = 0; i < m; i++) {
            double result = -1.0;
            List<String> list = queries.get(i);
            String x = list.get(0);
            String y = list.get(1);
            if (map.containsKey(x) && map.containsKey(y)) {
                int a = map.get(x), b = map.get(y);
                int fa = find(f,w,a), fb = find(f,w,b);
                if (fa == fb) {
                    result = w[a] / w[b];
                }
            }
            res[i] = result;
        }
        return res;
    }


    public int find(int[] f, double[] w, int x) {
        if (f[x] != x) {
            int fx = find(f, w, f[x]);
            // 到根节点的距离，等于 当前权值*父节点到根节点的距离
            w[x] = w[x] * w[f[x]];
            f[x] = fx;
        }
        return f[x];
    }

    public void merge(int[] f, double[] w, int x, int y, double k) {
        int fx = find(f, w, x), fy = find(f, w, y);
        f[fx] = fy;
        w[fx] = k * w[y] / w[x];
    }
}