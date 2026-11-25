public class Solution {
    private static final long BASE = 100003L;
    private static final long MOD = 1_000_000_000_000_000_003L; // or use two mods / HashMap to avoid collisions

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (hasUniqueOfLength(nums, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean hasUniqueOfLength(int[] nums, int len) {
        int n = nums.length;
        Map<Long, Integer> freq = new HashMap<>();

        long h1 = 0;
        long h2 = 0;
        long base1 = 100003L;
        long base2 = 1000019L;
        long mod1 = 1_000_000_007L;
        long mod2 = 1_000_000_009L;

        long pow1 = 1;
        long pow2 = 1;
        for (int i = 0; i < len - 1; i++) {
            pow1 = (pow1 * base1) % mod1;
            pow2 = (pow2 * base2) % mod2;
        }

        for (int i = 0; i < n; i++) {
            if (i >= len) {
                long outVal = nums[i - len] + 1L;
                h1 = (h1 - (outVal * pow1) % mod1 + mod1) % mod1;
                h2 = (h2 - (outVal * pow2) % mod2 + mod2) % mod2;
            }

            long inVal = nums[i] + 1L;
            h1 = (h1 * base1 + inVal) % mod1;
            h2 = (h2 * base2 + inVal) % mod2;

            if (i >= len - 1) {
                long key = (h1 << 32) ^ (h2 & 0xffffffffL);
                freq.put(key, freq.getOrDefault(key, 0) + 1);
            }
        }

        for (int count : freq.values()) {
            if (count == 1) {
                return true;
            }
        }
        return false;
    }
}