/**
 * @author qybit
 * @create 2020-11-30 15:10
 */
public class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        int[] g = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = g[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    g[i] = Math.max(g[i], g[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (f[i] > 1 && g[i] > 1) {
                res = Math.max(res, g[i] + f[i] - 1);
            }
        }
        return n - res;
    }
}
