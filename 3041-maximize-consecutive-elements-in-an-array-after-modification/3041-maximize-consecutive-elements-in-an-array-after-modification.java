class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> dp = new HashMap<>();
        int maxLen = 0;

        for (int num : nums) {
            // Option 1: Increase current element by 1 (becomes num + 1)
            int inc = dp.getOrDefault(num, 0) + 1;
            dp.put(num + 1, inc);

            // Option 2: Keep current element as num
            int stay = dp.getOrDefault(num - 1, 0) + 1;
            dp.put(num, stay);

            maxLen = Math.max(maxLen, Math.max(inc, stay));
        }

        return maxLen;
    }
}
