/**
 * @author qybit
 * @create 2020-12-25 15:18
 */
public class Solution {
    public int specialArray(int[] nums) {
        for (int i = 0; i <= 100; i++) {
            int cnt = 0;
            for (int j : nums) if (i <= j) cnt++;
            if (cnt == i) return i;
        }
        return -1;
    }
}
