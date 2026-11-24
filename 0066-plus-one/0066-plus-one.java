class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Start from the rightmost digit and move left
        for (int i = n - 1; i >= 0; i--) {
            // If the digit is less than 9, simply add 1 and return immediately
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // If the digit is 9, it becomes 0 and the carry moves left
            digits[i] = 0;
        }

        // If all digits were 9 (e.g., [9, 9, 9]), create a new array like [1, 0, 0, 0]
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}