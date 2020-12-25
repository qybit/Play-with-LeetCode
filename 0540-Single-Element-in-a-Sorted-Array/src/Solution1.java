/**
 * @author qybit
 * @create 2020-12-25 14:54
 */
public class Solution1 {

    public int singleNonDuplicate(int[] nums) {
        int res = 0;
        for (int x : nums) res ^= x;
        return res;
    }
}
