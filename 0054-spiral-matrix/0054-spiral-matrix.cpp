class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        vector<int> result;
        if (matrix.empty()) return result;
        
        int top = 0;
        int bottom = matrix.size() - 1;
        int left = 0;
        int right = matrix[0].size() - 1;
        
        while (top <= bottom && left <= right) {
            // 1. Traverse from left to right along the top boundary
            for (int i = left; i <= right; ++i) {
                result.push_back(matrix[top][i]);
            }
            top++; // Move the top boundary down
            
            // 2. Traverse from top to bottom along the right boundary
            for (int i = top; i <= bottom; ++i) {
                result.push_back(matrix[i][right]);
            }
            right--; // Move the right boundary left
            
            // 3. Traverse from right to left along the bottom boundary
            if (top <= bottom) { // Check to ensure we are still within valid rows
                for (int i = right; i >= left; --i) {
                    result.push_back(matrix[bottom][i]);
                }
                bottom--; // Move the bottom boundary up
            }
            
            // 4. Traverse from bottom to top along the left boundary
            if (left <= right) { // Check to ensure we are still within valid columns
                for (int i = bottom; i >= top; --i) {
                    result.push_back(matrix[i][left]);
                }
                left++; // Move the left boundary right
            }
        }
        
        return result;
    }
};