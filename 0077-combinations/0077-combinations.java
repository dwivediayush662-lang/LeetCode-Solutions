class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        // Base case: if the combination reaches size k, save a copy and return
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Loop through remaining numbers, pruning branches that don't have enough numbers left
        for (int i = start; i <= n - (k - current.size()) + 1; i++) {
            current.add(i);                            // Choose number i
            backtrack(i + 1, n, k, current, result);   // Explore further with i + 1
            current.remove(current.size() - 1);        // Undo the choice (backtrack)
        }
    }
}