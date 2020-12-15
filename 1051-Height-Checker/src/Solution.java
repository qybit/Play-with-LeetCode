import java.util.Arrays;

/**
 * @author qybit
 * @create 2020-12-15 8:56
 * @Since 1.0.0
 */
public class Solution {

    public int heightChecker(int[] heights) {
        int[] copyOf = Arrays.copyOf(heights, heights.length);
        Arrays.sort(copyOf);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != copyOf[i]) res++;
        }
        return res;
    }
}
