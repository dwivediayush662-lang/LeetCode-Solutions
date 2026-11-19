class Solution {
public:
    bool isSafe(int row, int col, vector<string>& board, int n) {
        int dupRow = row;
        int dupCol = col;

        // 1. ऊपरी बाएं विकर्ण (Upper-Left Diagonal) की जांच
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        // 2. बाईं ओर की पंक्ति (Left Row) की जांच
        row = dupRow;
        col = dupCol;
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        // 3. निचले बाएं विकर्ण (Lower-Left Diagonal) की जांच
        row = dupRow;
        col = dupCol;
        while (row < n && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row++;
            col--;
        }

        return true;
    }

    void solve(int col, vector<string>& board, vector<vector<string>>& ans, int n) {
        if (col == n) {
            ans.push_back(board);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                solve(col + 1, board, ans, n);
                board[row][col] = '.';
            }
        }
    }

    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> ans;
        vector<string> board(n, string(n, '.'));
        solve(0, board, ans, n);
        return ans;
    }
};