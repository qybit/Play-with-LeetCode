/**
 * @author qybit
 * @create 2020-12-17 8:49
 * @Since 1.0.0
 */
public class Solution {

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] f = new int[n][2];
        // f[i][0] 是没有股票的最大收入
        // f[i][1] 是持有股票的最大收入
        f[0][0] = 0;
        f[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            // 昨天没有股票， 昨天有股票，今天卖出
            f[i][0] = Math.max(f[i-1][0],f[i-1][1]+prices[i]-fee);
            // 昨天有股票，昨天没有股票，今天买入
            f[i][1] = Math.max(f[i-1][1], f[i-1][0]-prices[i]);
        }
        return f[n-1][0];
    }
}
