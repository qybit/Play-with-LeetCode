/**
 * @author qybit
 * @create 2020-12-13 18:51
 * @Since 1.0.0
 */
public class Solution {
    public int numberOfMatches(int n) {
        int res = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                res += n/2;
                n /= 2;
            } else {
                res += (n-1)/2;
                n = (n-1)/2 + 1;
            }
        }
        return res;
    }
}
