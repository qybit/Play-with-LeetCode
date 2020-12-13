import java.util.Arrays;

/**
 * @author qybit
 * @create 2020-12-13 14:08
 * @Since 1.0.0
 */
public class Solution {

    public int stoneGameVI(int[] a, int[] b) {
        int n = a.length;
        int[][] c = new int[n][];
        for (int i = 0; i < n; i++) {
            c[i] = new int[]{a[i] + b[i], a[i], b[i]};
        }
        Arrays.sort(c, (o1, o2) -> o2[0] - o1[0]);
        int as = 0, bs = 0;
        for (int i = 0; i < n; i++) {
            if (i%2==0) as += c[i][1];
            else bs += c[i][2];
        }
        if (as == bs) return 0;
        if (as > bs) return 1;
        return -1;
    }
}
