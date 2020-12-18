import java.util.Arrays;

/**
 * @author qybit
 * @create 2020-12-18 15:04
 * @Since 1.0.0
 */
public class Solution {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (o1, o2) -> o1[1] - o2[1]);
        int res = 1, t = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > t) {
                res++;
                t = pairs[i][1];
            }
        }
        return res;
    }
}
