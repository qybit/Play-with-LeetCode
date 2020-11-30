import java.util.TreeSet;

/**
 * @author qybit
 * @create 2020-11-30 16:23
 */
public class Solution {

    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num%2==0?num : num*2);
        }
        int res = set.last() - set.first();
        while (res > 0 && set.last()%2 == 0) {
            int num = set.last();
            set.remove(num);
            set.add(num/2);
            res = Math.min(res, set.last() - set.first());
        }
        return res;
    }
}
