/**
 * @author qybit
 * @create 2020-12-26 13:34
 */
public class Solution {

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int[][] f = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (j == 0) {
                        f[i][j] = 1;
                    } else {
                        f[i][j] = f[i][j - 1] + 1;
                    }
                } else {
                    f[i][j] = 0;
                }

                int minWidth = f[i][j];
                for (int k = i; k >= 0; k--) {
                    int h = i - k + 1;
                    minWidth = Math.min(minWidth, f[k][j]);
                    res = Math.max(res, h * minWidth);
                }
            }
        }
        return res;
    }
}
