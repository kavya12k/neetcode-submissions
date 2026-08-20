class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; // dp[i] = min. coins needed to make amt. i
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coinVal : coins) {
                if (coinVal <= i)
                    dp[i] = Math.min(dp[i], 1 + dp[i - coinVal]);
            }
        }
        
        if (dp[amount] > amount) {
            return -1;
        } else {
            return dp[amount];
        }   
    }
}
