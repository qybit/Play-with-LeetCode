import java.util.HashMap;
import java.util.Map;

/**
 * @author qybit
 * @create 2020-12-06 14:24
 * @Since 1.0.0
 */
public class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> fre = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            int x = k - num;
            if (fre.containsKey(x)) {
                if (fre.get(x) > 1) {
                    fre.put(x, fre.get(x) - 1);
                } else {
                    fre.remove(x);
                }
                res++;
            } else {
                fre.put(num, fre.getOrDefault(x, 0) + 1);
            }
        }
        return res;
    }
}
