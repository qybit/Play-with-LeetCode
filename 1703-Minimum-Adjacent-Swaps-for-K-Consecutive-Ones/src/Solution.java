import java.util.ArrayList;
import java.util.List;

/**
 * @author qybit
 * @create 2020-12-28 15:58
 */
public class Solution {

    public int minMoves(int[] nums, int k) {
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) a.add(i - a.size());
        }
        int n = a.size();
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) s[i] = s[i - 1] + a.get(i - 1);
        int res = Integer.MAX_VALUE;
        for (int i = k; i <= n; i++) {
            int l = i - k + 1;
            int r = i;
            int mid = l + r >> 1;
            int x = a.get(mid - 1);
            int left = (mid - l) * x - (s[mid - 1] - s[l - 1]);
            int right = (s[r] - s[mid]) - x * (r - mid);
            res = Math.min(res, left + right);
        }
        return res;
    }
}
