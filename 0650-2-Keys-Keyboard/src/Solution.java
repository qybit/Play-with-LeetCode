/**
 * @author qybit
 * @create 2020-12-19 17:01
 * @Since 1.0.0
 */
public class Solution {
    public int minSteps(int n) {
        int res = 0;
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                res += i;
                n /= i;
            }
        }
        if (n > 1) res += n;
        return res;
    }
}
