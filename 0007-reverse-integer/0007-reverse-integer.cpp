#include <climits>

class Solution {
public:
    int reverse(int x) {
        int reversed = 0;
        
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            
            // 1. Predict positive overflow: INT_MAX is 2147483647
            if (reversed > INT_MAX / 10 || (reversed == INT_MAX / 10 && pop > 7)) {
                return 0;
            }
            
            // 2. Predict negative underflow: INT_MIN is -2147483648
            if (reversed < INT_MIN / 10 || (reversed == INT_MIN / 10 && pop < -8)) {
                return 0;
            }
            
            // 3. Safe to compute if checks pass
            reversed = reversed * 10 + pop;
        }
        
        return reversed;
    }
};