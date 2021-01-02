import java.util.ArrayList;
import java.util.List;

/**
 * @author qybit
 * @create 2021-01-02 9:19
 */
public class Solution {

    int[] q = new int[1_00_010];
    int hh = 0, tt = -1;

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (hh <= tt && i - k + 1 > q[hh]) hh++;
            while (hh <= tt && nums[q[tt]] <= nums[i]) tt--;
            q[++tt] = i;
            if (i - k + 1 >= 0) res.add(nums[q[hh]]);
        }
        int[] ans = new int[res.size()];
        int i = 0;
        for (int x : res) ans[i++] = x;
        return ans;
    }
}
