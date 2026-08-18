class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = prices[0];
        for (int sell : prices) {
            maxProfit = Math.max(sell - buy, maxProfit);
            buy = Math.min(sell, buy);
        }
        return maxProfit;
    }
}
