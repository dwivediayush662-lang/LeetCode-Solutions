class Solution {
public:
    int trap(vector<int>& height) {
        if (height.empty()) return 0;

        int left = 0;
        int right = height.size() - 1;

        int leftMax = 0;
        int rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // Update max boundary
                } else {
                    totalWater += leftMax - height[left]; // Trap water
                }
                left++;
            } else {
                // Work on the right side
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // Update max boundary
                } else {
                    totalWater += rightMax - height[right]; // Trap water
                }
                right--;
            }
        }
        
        return totalWater;
    }
};
            