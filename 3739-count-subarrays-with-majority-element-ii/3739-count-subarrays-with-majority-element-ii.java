class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] freq = new int[2 * n + 1];
        
        int prefixSum = n; 
        freq[prefixSum] = 1;
        
        long ans = 0;
        long validBefore = 0; 

        for (int num : nums) {
            if (num == target) {
                validBefore += freq[prefixSum];
                prefixSum++;
            } else {
                prefixSum--;
                validBefore -= freq[prefixSum];
            }
            
            ans += validBefore;
            freq[prefixSum]++;
        }

        return ans;
    }
}