import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author qybit
 * @create 2020-12-30 9:15
 */
public class Solution {

    public int lastStoneWeight(int[] stones) {
        List<Integer> res = new ArrayList<>();
        for (int n : stones) res.add(n);
        while (res.size() > 1) {
            Collections.sort(res);
            int n = res.size();
            int x = res.get(n-2), y = res.get(n-1);
            res.remove(n-1);
            res.remove(n-2);
            if (x != y) res.add(y - x);
        }
        return res.isEmpty() ? 0 : res.get(0);
    }
}
