/**
 * @author qybit
 * @create 2020-12-28 11:31
 */
public class Solution {

    public double averageWaitingTime(int[][] customers) {
        long res = 0;
        int n = customers.length;
        for (int i = 0, t  = 0; i < n; i++) {
            t = Math.max(customers[i][0], t);
            t += customers[i][1];
            res += t - customers[i][0];
        }
        return res * 1.0/ n;
    }
}
