class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;
        
        // Build list [1, 2, ..., n] and compute (n - 1)!
        for (int i = 1; i < n; i++) {
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);
        
        StringBuilder ans = new StringBuilder();
        k = k - 1; // Convert k to 0-based index
        
        while (true) {
            int index = k / fact;
            ans.append(numbers.get(index));
            numbers.remove(index);
            
            if (numbers.isEmpty()) {
                break;
            }
            
            k = k % fact;
            fact = fact / numbers.size();
        }
        
        return ans.toString();
    }
}