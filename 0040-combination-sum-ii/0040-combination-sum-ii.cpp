class Solution {
public:
    void backtrack(int index, int target, std::vector<int>& candidates, 
                   std::vector<int>& current, std::vector<std::vector<int>>& result) {
        if (target == 0) {
            result.push_back(current);
            return;
        }
        
        for (int i = index; i < candidates.size(); ++i) {
            // Skip duplicate elements at the same decision level
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            
            // Optimization: stop if the element exceeds the remaining target
            if (candidates[i] > target) break;
            
            current.push_back(candidates[i]);
            backtrack(i + 1, target - candidates[i], candidates, current, result);
            current.pop_back(); // Backtrack
        }
    }

    std::vector<std::vector<int>> combinationSum2(std::vector<int>& candidates, int target) {
        std::vector<std::vector<int>> result;
        std::vector<int> current;
        
        // Sorting helps to handle duplicates easily and optimize constraints
        std::sort(candidates.begin(), candidates.end());
        
        backtrack(0, target, candidates, current, result);
        return result;
    }
};