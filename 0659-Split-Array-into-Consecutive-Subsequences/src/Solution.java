import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author qybit
 * @create 2020-12-04 8:46
 */
public class Solution {

    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, new PriorityQueue<>());
            }
            if (map.containsKey(num - 1)) {// 有连续的子序列，此时
                int preLen = map.get(num - 1).poll();
                if (map.get(num-1).isEmpty()) {
                    map.remove(num-1);
                }
                map.get(num).offer(preLen+1);
            } else {//没有连续的子序列，长度初始化为1
                map.get(num).offer(1);
            }
        }
        Set<Map.Entry<Integer, PriorityQueue<Integer>>> set = map.entrySet();
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : set) {
            PriorityQueue<Integer> value = entry.getValue();
            if (!value.isEmpty() && value.peek() < 3) {
                return false;
            }
        }
        return true;
    }
}
