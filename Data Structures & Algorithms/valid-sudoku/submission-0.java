class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] has;

        for (int i = 0; i < 9; i++) {
            has = new boolean[10];

            for (int j = 0; j < 9; j++) {
                if (isNumber(board[i][j])) {
                    if (has[board[i][j] - '0']) {
                        return false;
                    }
                    has[board[i][j] - '0'] = true;
                }
            }

            has = new boolean[10];

            for (int j = 0; j < 9; j++) {
                if (isNumber(board[j][i])) {
                    if (has[board[j][i] - '0']) {
                        return false;
                    }
                    has[board[j][i] - '0'] = true;
                }
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                has = new boolean[10];

                for (int l = i; l < 3 + i; l++) {
                    for (int m = j; m < 3 + j; m++) {
                       if (isNumber(board[l][m])) {
                            if (has[board[l][m] - '0']) {
                                return false;
                            }
                            has[board[l][m] - '0'] = true;
                        } 
                    }
                }
            }
        }
        return true;
    }

    private boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }
}
