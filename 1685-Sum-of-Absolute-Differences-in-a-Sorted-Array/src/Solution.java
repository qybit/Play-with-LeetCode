/**
 * @author qybit
 * @create 2020-12-13 13:08
 * @Since 1.0.0
 */
public class Solution {

    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) s[i] = s[i-1] + nums[i-1];
        int[] res = new int[n];
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            int left = (i * nums[i-1]) - s[i];
            int right = s[n] - s[i] - (nums[i-1] * (n-i));
            res[idx++] = left+right;
        }
        return res;
    }
}
