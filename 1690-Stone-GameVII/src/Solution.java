/**
 * @author qybit
 * @create 2020-12-17 15:26
 * @Since 1.0.0
 */
public class Solution {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) s[i] = s[i - 1] + stones[i - 1];

        int[][] f = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                f[i][j] = Math.max(s[j] - s[i] - f[i + 1][j], s[j - 1] - s[i - 1] - f[i][j - 1]);
            }
        }
        return f[1][n];
    }
}
