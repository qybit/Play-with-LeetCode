import java.util.Arrays;

/**
 * @author qybit
 * @create 2020-11-30 15:38
 */
public class Solution {

    public int maximumWealth(int[][] accounts) {
        int res = 0;
        for (int[] account : accounts) {
            res = Math.max(res, Arrays.stream(account).sum());
        }
        return res;
    }
}
