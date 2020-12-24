import java.util.Arrays;

/**
 * @author qybit
 * @create 2020-12-24 10:45
 */
public class Solution {

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) f[i] = f[i - 1] + 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) f[i] = Math.max(f[i] + 1, f[i]);
        }
//        int res = 0;
//        for (int x : f) res+=x;
        return Arrays.stream(f).sum();
    }
}
