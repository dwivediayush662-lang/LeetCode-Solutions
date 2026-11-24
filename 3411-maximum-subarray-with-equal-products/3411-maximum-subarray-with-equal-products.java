class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        // Maximum possible LCM for 1..10 is 2520, and max GCD is 10 -> 25200
        int maxPossible = 25200;

        for (int i = 0; i < n; i++) {
            long prod = 1;
            int gcdVal = 0;
            long lcmVal = 1;

            for (int j = i; j < n; j++) {
                prod *= nums[j];
                if (prod > maxPossible) {
                    break;
                }

                gcdVal = gcd(gcdVal, nums[j]);
                lcmVal = lcm(lcmVal, nums[j]);

                if (prod == (long) gcdVal * lcmVal) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd((int) a, (int) b)) * b;
    }
}