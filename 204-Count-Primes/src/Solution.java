/**
 * @author qybit
 * @create 2020-12-03 8:43
 */
public class Solution {

    public int countPrimes(int n) {
        boolean[] flag = new boolean[n];
        int res = 0;
        if (n > 2) {
            res++;
        }
        for (int i = 3; i < n; i += 2) {
            if (!flag[i]) {
                for (int j = 3; i * j < n; j += 2) {
                    flag[i * j] = true;
                }
                res++;
            }
        }
        return res;
    }
}
