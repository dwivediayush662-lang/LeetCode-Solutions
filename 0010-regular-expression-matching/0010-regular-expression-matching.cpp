class Solution {
public:
    bool isMatch(std::string s, std::string p) {
        int m = s.length();
        int n = p.length();
        
        // dp[i][j] will be true if s[0..i-1] matches p[0..j-1]
        std::vector<std::vector<bool>> dp(m + 1, std::vector<bool>(n + 1, false));
        
        // Base case: Empty string matches empty pattern
        dp[0][0] = true;
        
        // Base cases for patterns like a*, a*b*, a*b*c* matching empty string s
        for (int j = 2; j <= n; ++j) {
            if (p[j - 1] == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                // Case 1: The current characters match, or pattern has '.'
                if (p[j - 1] == s[i - 1] || p[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // Case 2: The pattern character is '*'
                else if (p[j - 1] == '*') {
                    // Sub-case A: Count '*' as zero occurrences of the preceding character
                    dp[i][j] = dp[i][j - 2];
                    
                    // Sub-case B: Count '*' as 1 or more occurrences
                    // Check if preceding pattern character matches current string character
                    if (p[j - 2] == s[i - 1] || p[j - 2] == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        
        return dp[m][n];
    }
};