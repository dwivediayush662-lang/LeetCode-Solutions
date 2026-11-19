class Solution {
public:
    std::vector<int> findSubstring(std::string s, std::vector<std::string>& words) {
        std::vector<int> result;
        if (s.empty() || words.empty()) return result;

        int word_len = words[0].length();
        int num_words = words.size();
        int total_len = word_len * num_words;
        int s_len = s.length();

        if (s_len < total_len) return result;

        // Count expected word frequencies
        std::unordered_map<std::string, int> word_counts;
        for (const std::string& word : words) {
            word_counts[word]++;
        }

        // Run the sliding window for all possible word offsets (0 to word_len - 1)
        for (int i = 0; i < word_len; ++i) {
            int left = i, right = i;
            int count = 0;
            std::unordered_map<std::string, int> seen_words;

            // Expand the window to the right by word chunks
            while (right + word_len <= s_len) {
                std::string word = s.substr(right, word_len);
                right += word_len;

                // Case 1: The chunk is a valid target word
                if (word_counts.count(word)) {
                    seen_words[word]++;
                    count++;

                    // If we have too many duplicates, shrink the window from the left
                    while (seen_words[word] > word_counts[word]) {
                        std::string left_word = s.substr(left, word_len);
                        seen_words[left_word]--;
                        count--;
                        left += word_len;
                    }

                    // If the window matches the exact number of words required
                    if (count == num_words) {
                        result.push_back(left);
                    }
                } 
                // Case 2: The chunk is invalid, reset the window entirely
                else {
                    seen_words.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
};