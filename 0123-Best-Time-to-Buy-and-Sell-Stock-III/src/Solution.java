class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 0; i < n; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(prices[i] + buy1, sell1);
            buy2 = Math.max(buy2, sell1-prices[i]);
            sell2 = Math.max(prices[i] + buy2, sell2);
        }
        return sell2;
    }
}