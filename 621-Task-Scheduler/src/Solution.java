import java.util.*;

/**
 * @author qybit
 * @create 2020-12-05 15:39
 * @Since 1.0.0
 */
public class Solution {

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int m = map.size();
        List<Integer> next = new ArrayList<>();
        List<Integer> rest=  new ArrayList<>();
        Set<Map.Entry<Character, Integer>> set = map.entrySet();
        for (Map.Entry<Character, Integer> entry : set) {
            int val = entry.getValue();
            next.add(1);
            rest.add(val);
        }
        int time = 0;
        for (int i = 0; i < tasks.length; i++) {
            time++;
            int minNext = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                if (rest.get(j) != 0) {
                    minNext = Math.min(next.get(j), minNext);
                }
            }
            time = Math.max(time, minNext);
            int best = -1;
            for (int j = 0; j < m; j++) {
                if (rest.get(j) != 0 && next.get(j) <= time) {
                    if (best == -1 || rest.get(j) > rest.get(best)) {
                        best = j;
                    }
                }
            }
            next.set(best, time + n + 1);
            rest.set(best, rest.get(best)-1);
        }
        return time;
    }
}
