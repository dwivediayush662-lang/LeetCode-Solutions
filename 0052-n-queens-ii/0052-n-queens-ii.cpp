class Solution {
public:
    int totalNQueens(int n) {
        int count = 0;

        auto backtrack = [&](auto& self, int row, int cols, int diag1, int diag2) -> void {
            if (row == n) {
                count++;
                return;
            }
             int safe_squares = ((1 << n) - 1) & ~(cols | diag1 | diag2);
             while (safe_squares > 0) {
                int current_queen_bit = safe_squares & -safe_squares;
                safe_squares -= current_queen_bit;
                self(self, row + 1, cols | current_queen_bit, (diag1 | current_queen_bit) << 1, (diag2 | current_queen_bit) >> 1);
            }
        };
        backtrack(backtrack, 0, 0, 0, 0);
        
        return count;
    }
};