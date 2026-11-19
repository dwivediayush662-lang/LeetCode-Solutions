class Solution {
public:
    double myPow(double x, int n) {
        long long power = n;
        
        // Make power positive, but keep x as-is to preserve full precision
        if (power < 0) {
            power = -power;
        }
        
        double result = 1.0;
        
        while (power > 0) {
            if (power % 2 == 1) {
                result *= x;
            }
            x *= x;
            power /= 2;
        }
        
        // Apply the negative exponent at the very end
        return (n < 0) ? (1.0 / result) : result;
    }
};