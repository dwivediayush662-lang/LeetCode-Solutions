class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int minPrice = Integer.MAX_VALUE;
        int maxFactor = 0;

        for (int[] item : items) {
            minPrice = Math.min(minPrice, item[1]);
            maxFactor = Math.max(maxFactor, item[0]);
        }

        // Count frequency of each factor
        int[] freq = new int[maxFactor + 1];
        for (int[] item : items) {
            freq[item[0]]++;
        }

        // Compute bonus[i] for each item using harmonic series: O(M log M)
        int[] bonus = new int[maxFactor + 1];
        for (int f = 1; f <= maxFactor; f++) {
            if (freq[f] == 0) continue;
            int count = -1; // exclude self
            for (int mult = f; mult <= maxFactor; mult += f) {
                count += freq[mult];
            }
            bonus[f] = count;
        }

        // Pair each item's [price, bonusCount] and sort by price ascending
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = items[i][1];
            pairs[i][1] = bonus[items[i][0]];
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        long remBudget = budget;
        long bonusItemsCount = 0;
        long ans = remBudget / minPrice;

        for (int[] p : pairs) {
            long price = p[0];
            long maxCopies = p[1];

            // Buying for bonus only helps if price < 2 * minPrice
            if (price >= 2L * minPrice) {
                break;
            }
            if (maxCopies == 0) {
                continue;
            }

            long canBuy = Math.min(maxCopies, remBudget / price);
            if (canBuy > 0) {
                remBudget -= canBuy * price;
                bonusItemsCount += 2L * canBuy;
                ans = Math.max(ans, bonusItemsCount + (remBudget / minPrice));
            }

            // If we couldn't even buy all bonus copies of this item, we can't afford pricier ones
            if (canBuy < maxCopies) {
                break;
            }
        }

        return (int) ans;
    }
}