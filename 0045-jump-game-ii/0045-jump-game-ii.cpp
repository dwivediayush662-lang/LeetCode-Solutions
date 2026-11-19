class Solution {
public:
    int jump(vector<int>& nums) {
        int jumps = 0;        // Counts total jumps made
        int currentEnd = 0;   // The farthest index we can reach with current jumps
        int farthest = 0;     // The farthest index we can reach overall
        
        // Loop up to n - 2 because we don't need to jump once we reach the last index
        for (int i = 0; i < nums.size() - 1; i++) {
            // Update the farthest point reachable from the current index
            farthest = max(farthest, i + nums[i]);
            
            // If we have reached the end of our current jump's range, we must jump again
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }
        
        return jumps;
    }
};