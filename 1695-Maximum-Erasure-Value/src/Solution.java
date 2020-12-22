import java.util.HashMap;
import java.util.Map;

/**
 * @author qybit
 * @create 2020-12-22 20:33
 */
public class Solution {

    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) s[i] = s[i - 1] + nums[i - 1];

        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];

            if (map.containsKey(cur)) {
                start = Math.max(start, map.get(cur) + 1);
            }

            res = Math.max(res, s[i + 1] - s[start]);

            map.put(cur, i);
            // System.out.println(start);
        }
        return res;
    }
}
