class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        // Loop up to n (inclusive) so we can process all remaining bars at the end
        for (int i = 0; i <= n; i++) {
            // Use height 0 at the very end to force all remaining bars out of the stack
            int currentHeight = (i == n) ? 0 : heights[i];

            // Pop taller bars and calculate the largest rectangle they can form
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                
                // Width spans from the element right after the new stack top to i - 1
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                
                maxArea = Math.max(maxArea, height * width);
            }

            // Push the current bar's index onto the stack
            stack.push(i);
        }

        return maxArea;
    }
}