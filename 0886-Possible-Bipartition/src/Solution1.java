import java.util.*;

/**
 * @author qybit
 * @create 2020-12-04 9:53
 */
public class Solution1 {

    static class DSU {
        int[] f;

        public DSU(int n) {
            f = new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = i;
            }
        }

        public int find(int x) {
            if (f[x] == x) return x;
            return find(f[x]);
        }

        public void join(int a, int b) {
            int fx = find(a), fy = find(b);
            if (f[fx] != fy) f[fx] = fy;
        }
        public boolean isConnected(int a, int b) {
            return find(a) == find(b);
        }
    }

    public boolean possibleBipartition(int N, int[][] dislikes) {
        DSU dsu = new DSU(2 * N+1);
        for (int[] d : dislikes) {
            int x = d[0]; // 自己的节点
            int y = d[1]; // 不喜欢的人的节点
            int xb = d[0] + N; // 自己不喜欢的人群根节点
            int yb = d[1] + N; // 自己不喜欢的不喜欢的人群根节点
            if (dsu.isConnected(x, y)) {
                return false;
            }
            dsu.join(x, yb);
            dsu.join(y, xb);
        }
        return true;
    }
}
