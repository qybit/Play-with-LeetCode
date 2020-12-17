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

        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 < n; i++) {

            }
        }
    }
}
