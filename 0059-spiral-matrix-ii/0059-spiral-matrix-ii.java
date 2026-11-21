class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int num = 1;

        while (num <= n * n) {
            // 1. Go Right
            for (int i = left; i <= right; i++) mat[top][i] = num++;
            top++;

            // 2. Go Down
            for (int i = top; i <= bottom; i++) mat[i][right] = num++;
            right--;

            // 3. Go Left
            for (int i = right; i >= left; i--) mat[bottom][i] = num++;
            bottom--;

            // 4. Go Up
            for (int i = bottom; i >= top; i--) mat[i][left] = num++;
            left++;
        }

        return mat;
    }
}