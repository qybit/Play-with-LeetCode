/**
 * @author qybit
 * @create 2020-12-18 10:38
 * @Since 1.0.0
 */
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int[] s = new int[n+1];
        for (int i = 1; i <= n; i++) s[i] = s[i-1] + nums[i-1];
        double res = -100000;
        for (int i = 0; i + k <= n; i++) {
            res = Math.max(res, (s[i+k]-s[i])*1.0/k);
        }
        return res;
    }
}
