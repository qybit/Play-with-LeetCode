import java.util.Arrays;

/**
 * @author qybit
 * @create 2020-12-31 9:19
 */
public class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[1] - o2[1];

        });
        int res = 0;
        int ed = Integer.MIN_VALUE;
        for (int[] p : intervals) {
            if (ed > p[0]) {
                res++;
            } else {
                ed = p[1];
            }
        }
        return res;
    }
}
