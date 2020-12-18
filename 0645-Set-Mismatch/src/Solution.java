/**
 * @author qybit
 * @create 2020-12-18 10:55
 * @Since 1.0.0
 */
public class Solution {

    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] f = new int[n+1];
        for (int x : nums) f[x]++;

        int[] res = new int[2];
        for (int i = 1; i <= n; i++) {
            if (f[i] > 1) res[0] = i;
            else if (f[i] == 0) res[1] = i;
        }
        return res;
    }
}
