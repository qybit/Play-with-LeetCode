/**
 * @author qybit
 * @create 2020-11-30 15:53
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {1,2,4,3};
        s.minMoves(a,4);
    }

    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] f = new int[2*limit + 2];
        for (int i = 0; i < n/2; i++) {
            int A = nums[i], B = nums[n-1-i];

            int l = 2, r = 2*limit;
            f[l] += 2;
            f[r+1] -= 2;

            l = 1+Math.min(A, B);r = limit+Math.max(A, B);
            f[l] += -1;
            f[r+1] -= -1;

            l = A+B;r = A+B;
            f[l] += -1;
            f[r+1] -= -1;
        }
        int sum = 0, res = n;
        for (int i = 2; i <= 2*limit; i++) {
            sum += f[i];
            res = Math.min(res, sum);
        }
        return res;
    }
}
