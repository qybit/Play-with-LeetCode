/**
 * @author qybit
 * @create 2020-12-17 14:55
 * @Since 1.0.0
 */
public class Solution {

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + stoneValue[i - 1];
        }
        int[][] f = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                // 左右边界
                for (int m = i; m <= j; m++) {
                    if (i > m || m + 1 > j) continue;
                    int l = f[i][m];
                    int r = f[m + 1][j];
                    int ls = s[m] - (i > 0 ? s[i - 1] : 0);
                    int rs = s[j] - s[m];

                    // Alice 决定丢弃那一边，丢掉最小的一部分
                    if (ls == rs) {
                        int score = Math.max(l, r) + ls;
                        f[i][j] = Math.max(f[i][j], score);
                    } else {
                        if (ls > rs) {
                            f[i][j] = Math.max(f[i][j], r + rs);
                        } else {
                            f[i][j] = Math.max(f[i][j], l + ls);
                        }
                    }
                }
            }
        }
        return f[1][n];
    }
}
