import java.util.Arrays;

/**
 * @author qybit
 * @create 2020-12-06 17:23
 * @Since 1.0.0
 */
public class Solution {


    public int minimumIncompatibility(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[1 << n]; //
        int[] g = new int[1 << n];
        int[] d = new int[n/k];
        Arrays.fill(f, (int) 1e8);
        f[0] = 0;
        for (int i = 1; i < 1 << n; i++) {

            g[i] = -1;
            if (Integer.bitCount(i) == n / k) {
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    if ((i >> j & 1) == 1) {
                        d[cnt++] = nums[j];
                    }
                }
                Arrays.sort(d);
                int flag = 1, max = d[0], min = d[0];
                for (int j = 1; j < cnt; j++) {
                    if (d[j] == d[j - 1]) {
                        flag = 0;
                        break;
                    }
                    max = Math.max(max, d[j]);
                    min = Math.min(min, d[j]);
                }
                if (flag == 1) {
                    g[i] = max - min;
                }
            }
        }

        for (int i = 1; i < 1 << n; i++) {
            for (int j = i; j > 0; j = i & (j - 1)) {
                if (g[j] != -1) {
                    f[i] = Math.min(f[i], f[i - j] + g[j]);
                }
            }
        }
        int res = f[(1 << n) - 1];
        if (res == Integer.MAX_VALUE) res = -1;
        return res;
    }
}
