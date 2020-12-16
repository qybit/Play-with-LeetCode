import java.util.HashMap;
import java.util.Map;

/**
 * @author qybit
 * @create 2020-12-16 14:48
 * @Since 1.0.0
 */
public class Solution {

    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (int i  : map.keySet()) {
            if (k == 0) {
                if (map.get(i) > 1) res++;
            } else {
                if (map.containsKey(i + k)) res++;
            }
        }
        return res;
    }
}
