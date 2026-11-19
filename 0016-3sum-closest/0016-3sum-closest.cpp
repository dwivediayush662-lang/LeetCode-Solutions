class Solution {
public:
    int threeSumClosest(std::vector<int>& nums, int target) {
        int n = nums.size();
        
        // Step 1: Sort the array to use the two-pointer technique
        std::sort(nums.begin(), nums.end());
        
        // Initialize closest_sum with a dummy value that is far away
        // We use a large window but avoid INT_MAX to prevent potential overflow issues
        int closest_sum = nums[0] + nums[1] + nums[2];
        
        for (int i = 0; i < n - 2; i++) {
            // Optional: Skip duplicate values for the first element to optimize execution
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                int current_sum = nums[i] + nums[left] + nums[right];
                
                // If we find an exact match to the target, it's the closest possible sum
                if (current_sum == target) {
                    return current_sum;
                }
                
                // Update closest_sum if the current_sum is closer to the target
                if (std::abs(current_sum - target) < std::abs(closest_sum - target)) {
                    closest_sum = current_sum;
                }
                
                // Adjust pointers based on how current_sum compares to target
                if (current_sum < target) {
                    left++; // We need a larger sum
                } else {
                    right--; // We need a smaller sum
                }
            }
        }
        
        return closest_sum;
    }
};