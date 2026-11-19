class Solution {
public:
    int myAtoi(std::string s) {
        int i = 0;
        int n = s.length();
        
        // 1. Skip leading whitespaces
        while (i < n && s[i] == ' ') {
            i++;
        }
        
        // 2. Check for sign
        int sign = 1;
        if (i < n && (s[i] == '-' || s[i] == '+')) {
            if (s[i] == '-') {
                sign = -1;
            }
            i++;
        }
        
        long long result = 0;
        
        // 3. Convert digits and handle overflow
        while (i < n && std::isdigit(s[i])) {
            result = result * 10 + (s[i] - '0');
            
            // Check and handle 32-bit signed integer overflow/underflow
            if (sign == 1 && result > INT_MAX) {
                return INT_MAX;
            }
            if (sign == -1 && -result < INT_MIN) {
                return INT_MIN;
            }
            
            i++;
        }
        
        return static_cast<int>(result * sign);
    }
};