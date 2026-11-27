class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int minPrice = Integer.MAX_VALUE;

        // dp[c] = max items gained by buying the first copy of chosen items costing c
        int[] dp = new int[budget + 1];

        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];
            minPrice = Math.min(minPrice, price);

            // Count how many items have a factor divisible by this item's factor
            int gain = 0;
            for (int[] other : items) {
                if (other[0] % factor == 0) {
                    gain++;
                }
            }

            // 0/1 Knapsack: each item's "first copy" can be taken at most once
            for (int c = budget; c >= price; c--) {
                dp[c] = Math.max(dp[c], dp[c - price] + gain);
            }
        }

        int ans = 0;
        for (int c = 0; c <= budget; c++) {
            int extraCopies = (budget - c) / minPrice;
            ans = Math.max(ans, dp[c] + extraCopies);
        }

        return ans;
    }
}