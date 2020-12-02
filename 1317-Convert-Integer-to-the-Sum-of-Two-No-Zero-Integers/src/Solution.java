/**
 * @author qybit
 * @create 2020-12-02 15:42
 */
public class Solution {

    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            int a = i, b = n-i;
            if (check(a) && check(b)) {
                return new int[]{a, b};
            }
        }
        return new int[]{0, 0};
    }

    private boolean check(int x) {
        while (x != 0) {
            if (x%10==0) {
                return false;
            }
            x /= 10;
        }
        return true;
    }
}
