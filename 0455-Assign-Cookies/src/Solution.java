import java.util.Arrays;

/**
 * @author qybit
 * @create 2020-12-25 8:47
 */
public class Solution {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0, res = 0;
        while (i < g.length && j < s.length) {
            if (s[j] < g[i]) {
                j++;
                continue;
            }
            i++;
            j++;
            res++;
        }
        return res;
    }
}
