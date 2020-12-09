/**
 * @author qybit
 * @create 2020-12-09 14:49
 * @Since 1.0.0
 */
public class Solution {

    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        // f[i][j] 表示删除s1的前i个字母和删除s2的前j个字母的后，使两字符串相等的最小ascii消耗
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            f[i][0] = f[i - 1][0] + s1.codePointAt(i - 1);
        }

        for (int i = 1; i <= n; i++) {
            f[0][i] = f[0][i - 1] + s2.codePointAt(i - 1);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1];
                } else {
                    f[i][j] = Math.min(f[i - 1][j] + s1.codePointAt(i - 1), f[i][j - 1] + s2.codePointAt(j - 1));
                }
            }

        }
        return f[m][n];
    }
}
