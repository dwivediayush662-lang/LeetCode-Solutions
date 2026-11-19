#include <vector>
#include <string>

class Solution {
public:
    void generate(int open, int close, int n, std::string current, std::vector<std::string>& result) {
        if (open == n && close == n) {
            result.push_back(current);
            return;
        }
        if (open < n) {
            generate(open + 1, close, n, current + "(", result);
        }
        if (close < open) {
            generate(open, close + 1, n, current + ")", result);
        }
    }

    std::vector<std::string> generateParenthesis(int n) {
        std::vector<std::string> result;
        generate(0, 0, n, "", result);
        return result;
    }
};