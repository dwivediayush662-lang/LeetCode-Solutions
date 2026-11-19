class Solution {
public:
    vector<string> letterCombinations(string digits) {
        if (digits.empty()) return {};

        std::vector<std::string> keypad = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        std::vector<std::string> result = {""};

        for (char d : digits) {
             std::vector<std::string> temp;

              std::string letters = keypad[d - '0'];

              for (std::string s : result) {
                for (char c : letters) {
                    temp.push_back(s + c);
                }
              }
              result = temp ;
        }
        return result;

    }
};